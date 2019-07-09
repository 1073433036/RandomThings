package Cryptography;
// Stream cipher from AES counter mode ... no randomness, no integrity
//
// FOR EDUCATIONAL PURPOSES ONLY -- DO NOT USE IN PRODUCTION

import java.io.*;
import java.util.*;
import java.nio.ByteBuffer;
import java.nio.file.*;

import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.*;
import javax.crypto.SecretKeyFactory;

public class stream2AES {

	static final Scanner scan = new Scanner(System.in);

	// --- PRG based on AES in counter mode
	public static byte[] PRG(String seed, int len) {
		byte[] output = new byte[len];

		try {
			// Initialize AES with seed as the key (using PBKDF2)
			PBEKeySpec spec = new PBEKeySpec(seed.toCharArray(), "Gunn".getBytes(), 100000, 128);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			byte[] hash = skf.generateSecret(spec).getEncoded();
			Cipher aes = Cipher.getInstance("AES/ECB/NoPadding");
			SecretKeySpec AESkey = new SecretKeySpec(hash, "AES");
			aes.init(Cipher.ENCRYPT_MODE, AESkey);

			// Use AES in counter mode to generate pseudorandom sequence
			for (int i = 0; i < output.length; i += 16) {

				// Create 16-byte counter block of value = i
				byte[] counter = ByteBuffer.allocate(16).putInt(i).array();

				// evaluate AES at counter block
				byte[] block = aes.doFinal(counter);

				// copy result to output buffer
				for (int j = 0; j < 16 && i + j < output.length; j++)
					output[i + j] = block[j];
			}
		}
		catch (Exception ioe) {
			ioe.printStackTrace();
		}
		return output;
	}

	// --- Stream encryption (no randomness, integrity!)
	public static byte[] encrypt(String key, byte[] plaintext) {

		// Evaluate the PRG
		byte[] mask = PRG(key, plaintext.length);

		// Add PRG output to plaintext to get ciphertext
		byte[] ciphertext = new byte[plaintext.length];
		for (int i = 0; i < ciphertext.length; i++)
			ciphertext[i] = (byte) (plaintext[i] + mask[i]);

		return ciphertext;
	}

	// --- Stream decryption
	public static byte[] decrypt(String key, byte[] ciphertext) {

		// Evaluate the PRG
		byte[] mask = PRG(key, ciphertext.length);

		// Subtract PRG output from ciphertext to get plaintext
		byte[] plaintext = new byte[ciphertext.length];
		for (int i = 0; i < plaintext.length; i++)
			plaintext[i] = (byte) (ciphertext[i] - mask[i]);

		return plaintext;
	}

	// --- MAIN ---
	public static void main(String[] args) {

		String fileName, outputFile;
		byte[] dataOut;

		try {

			// Read filename from console
			System.out.print("Filename (without extension): ");
			fileName = scan.nextLine();

			// Load data
			String path = fileName;
			File f = new File(path + ".txt");
			if (!f.isFile()) {
				System.out.println("File " + f.getPath() + " does not exist.");
				System.exit(0);
			}
			byte[] data = Files.readAllBytes(f.toPath());

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
				byte[] dataIn = Base64.getDecoder().decode(data);

				dataOut = decrypt(key, dataIn);

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
