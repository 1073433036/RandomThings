package Cryptography;
// Stream cipher from AES counter mode and Carter-Wegman MAC
//
// FOR EDUCATIONAL PURPOSES ONLY -- DO NOT USE IN PRODUCTION

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.nio.file.*;
import java.math.BigInteger;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.*;
import javax.crypto.SecretKeyFactory;

public class stream4AESMAC {

	static final Scanner scan = new Scanner(System.in);

	// ----- PRG based on AES in counter mode -----
	public static byte[] PRG(String seed, byte[] iv, int len) {
		byte[] output = new byte[len];
		byte[] counter = new byte[16];

		try {
			// Initialize AES with seed as the key (using PBKDF2)
			PBEKeySpec spec = new PBEKeySpec(seed.toCharArray(), "Gunn".getBytes(), 100000, 128);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			byte[] hash = skf.generateSecret(spec).getEncoded();
			Cipher aes = Cipher.getInstance("AES/ECB/NoPadding");
			SecretKeySpec AESkey = new SecretKeySpec(hash, "AES");
			aes.init(Cipher.ENCRYPT_MODE, AESkey);

			// Initialize the IV
			BigInteger ivint = new BigInteger(1, iv);

			// Use AES in counter mode to generate pseudorandom sequence
			for (int i = 0; i < output.length; i += 16) {

				// Build the 16 byte AES block containing the counter value
				ivint = ivint.add(BigInteger.valueOf(1));
				byte[] val = ivint.toByteArray();
				for (int j = 0; j < 16; j++)
					counter[j] = (j < val.length) ? val[val.length - j - 1] : 0;

				// Evalute AES at the counter value
				byte[] block = aes.doFinal(counter);

				// Copy block into output buffer
				for (int j = 0; j < 16 && i + j < output.length; j++)
					output[i + j] = block[j];
			}
		}
		catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return output;
	}

	// ----- Carter-Wegman MAC -----
	public static byte[] computeMAC(String key, byte[] macMask, byte[] data) {

		// Set MAC key to be AES(key,0)
		byte[] zero = {};
		zero = Arrays.copyOfRange(zero, 0, 16);
		byte[] macKey = PRG(key, zero, 16);
		BigInteger macPt = new BigInteger(1, macKey);

		// Set prime = 2^128+51
		BigInteger prime = BigInteger.valueOf(2).pow(128);
		prime = prime.add(BigInteger.valueOf(51));

		// initialize mac to 1
		BigInteger mac = macPt;

		// Evaluate polynomial using Horner's method
		for (int i = 0; i < data.length; i += 16) {
			int len = Math.min(16, data.length - i);
			BigInteger m = new BigInteger(1, Arrays.copyOfRange(data, i, i + len));
			mac = mac.add(m);		// Horner's method
			mac = mac.multiply(macPt);
			mac = mac.mod(prime);
		}

		// encrypt the computed MAC
		mac = mac.add(new BigInteger(1, macMask)).mod(prime);

		// Convert to a 16-byte block
		byte[] macBytes = Arrays.copyOfRange(mac.toByteArray(), 0, 16);

		// Print MAC
		BigInteger macint = new BigInteger(1, macBytes);
		System.out.println("Computed MAC =      " + macint.toString(16));

		return macBytes;
	}

	// ----- Stream encryption -----
	public static byte[] encrypt(String key, byte[] plaintext) {

		// Generate a random iv
		SecureRandom random = new SecureRandom();
		byte iv[] = new byte[16];
		random.nextBytes(iv);
		System.out.println("IV = " + new BigInteger(1, iv).toString(16));

		// Store IV at beginning of ciphertext
		byte[] ciphertext = new byte[plaintext.length + 16];
		for (int i = 0; i < 16; i++)
			ciphertext[i] = iv[i];

		// Evaluate the PRG (16 additional bytes for masking the MAC)
		byte[] mask = PRG(key, iv, plaintext.length + 16);

		// Add PRG output to plaintext to get ciphertext
		for (int i = 0; i < plaintext.length; i++)
			ciphertext[i + 16] = (byte) (plaintext[i] + mask[i]);

		// Compute the MAC
		byte[] macMask = Arrays.copyOfRange(mask, mask.length - 16, mask.length);
		byte[] mac = computeMAC(key, macMask, ciphertext);

		// Append computed MAC to end of ciphertext
		byte[] fullCiphertext = new byte[ciphertext.length + 16];
		System.arraycopy(ciphertext, 0, fullCiphertext, 0, ciphertext.length);
		System.arraycopy(mac, 0, fullCiphertext, ciphertext.length, 16);

		return fullCiphertext;
	}

	// ----- Stream decryption -----
	public static byte[] decrypt(String key, byte[] ciphertext) throws BadMacException {

		// Extract IV
		byte[] iv = Arrays.copyOfRange(ciphertext, 0, 16);
		BigInteger ivint = new BigInteger(1, iv);
		System.out.println("IV in ciphertext =  " + ivint.toString(16));

		// Partition ciphertext into MAC and stripped ciphertext
		byte[] strippedCiphertext = Arrays.copyOfRange(ciphertext, 0, ciphertext.length - 16);
		byte[] macFromCiphertext = Arrays.copyOfRange(ciphertext, ciphertext.length - 16, ciphertext.length);

		// Evaluate the PRG
		byte[] mask = PRG(key, iv, ciphertext.length - 16);

		// Compute the MAC
		byte[] macMask = Arrays.copyOfRange(mask, mask.length - 16, mask.length);
		byte[] mac = computeMAC(key, macMask, strippedCiphertext);

		// Check that MAC in ciphertext is the same as computed MAC
		if (!Arrays.equals(mac, macFromCiphertext)) {
			BigInteger macint = new BigInteger(1, macFromCiphertext);
			System.out.println("MAC in ciphertext = " + macint.toString(16));
			throw new BadMacException();
		}

		// If MAC is valid, subtract PRG output from ciphertext to get plaintext
		byte[] plaintext = new byte[ciphertext.length - 2 * 16];
		for (int i = 0; i < plaintext.length; i++)
			plaintext[i] = (byte) (ciphertext[i + 16] - mask[i]);

		return plaintext;
	}

	// ----- MAIN -----
	public static void main(String[] args) {

		String fileName, outputFile;
		byte[] dataOut = {};

		try {

			// Read filename from console
			System.out.print("Filename (without extension): ");
			fileName = scan.nextLine();

			// Load data
			String path =fileName;
			File f = new File(path + ".txt");
			if (!f.isFile()) {
				System.out.println("File " + f.getPath() + " does not exist.");
				System.exit(0);
			}
			byte[] data = Files.readAllBytes(f.toPath());
			if (data.length > (1 << 29)) {
				System.out.println("File " + f.getPath() + " is too big.");
				System.exit(0);
			}

			// Read key from console
			String key;
			do {
				System.out.print("Key (at least eight chars): ");
				key = scan.nextLine();
			}
			while (key.length() < 8);

			// Choose encrypt or decrypt
			String type;
			do {
				System.out.print("Encrypt or decrypt [e|d]: ");
				type = scan.nextLine();
			}
			while ((type.charAt(0) != 'e') && (type.charAt(0) != 'd'));

			// Encrypt file
			if (type.charAt(0) == 'e') {
				System.out.println("Encrypting file: " + f.getPath());

				byte[] ciphertext = encrypt(key, data);

				// Write ciphertext to file in Base64
				dataOut = Base64.getEncoder().encode(ciphertext);
				outputFile = path + "_encrypted.txt";
			}

			// Decrypt file
			else {
				System.out.println("Decrypting file: " + f.getPath());

				if (data[data.length - 1] == 10)   // eliminate junk at end
					data = Arrays.copyOfRange(data, 0, data.length - 3);
				byte[] dataIn = Base64.getDecoder().decode(data);

				try {
					dataOut = decrypt(key, dataIn);
				}
				catch (BadMacException e) {
					System.out.println("\nError: wrong key or file integrity compromised !!\n");
					System.exit(0);
				}

				// Write plaintext data
				outputFile = path + "_decrypted.txt";
			}

			FileOutputStream out = new FileOutputStream(outputFile);
			out.write(dataOut);
			out.close();
			System.out.println("Created File " + outputFile);

		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}

class BadMacException extends Exception {
	public BadMacException() {
	}
}
