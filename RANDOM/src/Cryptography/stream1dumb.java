package Cryptography;
// Stream cipher with a dumb PRG
//
// FOR EDUCATIONAL PURPOSES ONLY -- DO NOT USE IN PRODUCTION

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Scanner;

public class stream1dumb {

	static final Scanner scan = new Scanner(System.in);

	// ----- Dumb PRG -----
	public static byte[] PRG(byte[] seed, int len) {
		byte[] output = new byte[len];
		for (int i = 0; i < output.length; i++)
			output[i] = seed[i % seed.length];
		return output;
	}

	// ----- Stream encryption -----
	public static byte[] encrypt(String key, byte[] plaintext) {

		// Evaluate the PRG
		byte[] mask = PRG(key.getBytes(), plaintext.length);

		// Add PRG output to plaintext to get ciphertext
		byte[] ciphertext = new byte[plaintext.length];
		for (int i = 0; i < ciphertext.length; i++)
			ciphertext[i] = (byte) (plaintext[i] + mask[i]);

		return ciphertext;
	}

	// ----- Stream decryption -----
	public static byte[] decrypt(String key, byte[] ciphertext) {

		byte[] plaintext = new byte[ciphertext.length];

		// Fill in the rest
		byte[] mask = PRG(key.getBytes(), ciphertext.length);

		for (int i = 0; i < mask.length; i++) {
			plaintext[i] = (byte) (ciphertext[i] - mask[i]);
		}

		return plaintext;
	}

	public static String getKeyAttack(byte[] ciphertext) {
		String key = "";
		int keylength = 8;
		for (int i = 0; i < keylength; i++) {
			int[] counts = new int[256];
			for (int j = i; j < ciphertext.length; j += keylength) {
				counts[Byte.toUnsignedInt(ciphertext[j])]++;
			}
			int max = 0;
			int maxInd = 0;
			for (int k = 0; k < counts.length; k++) {
				if (counts[k] > max) {
					maxInd = k;
					max = counts[k];
				}
			}

			char mappedLetter = (char) maxInd;
			char k = (char) (mappedLetter - ' ');
			key += k;
		}

		return key;
	}

	// ----- MAIN -----
	public static void main(String[] args) {

		String fileName = null, outputFile = null;
		byte[] dataOut = null;

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
				System.out.print("Key (8 chars): ");
				key = scan.nextLine();
			}
			while (key.length() != 8);

			// Choose encrypt or decrypt
			String type;
			do {
				System.out.print("Encrypt or decrypt or guess [e|d|g]: ");
				type = scan.nextLine();
			}
			while ((type.charAt(0) != 'e') && (type.charAt(0) != 'd') && (type.charAt(0) != 'g'));

			// Encrypt file
			if (type.charAt(0) == 'e') {
				System.out.println("Encrypting file: " + f.getPath());

				byte[] ciphertext = encrypt(key, data);

				// Write ciphertext to file in Base64
				dataOut = Base64.getEncoder().encode(ciphertext);
				outputFile = path + "_encrypted.txt";
			}

			// Decrypt file
			else if (type.charAt(0) == 'd') {
				System.out.println("Decrypting file: " + f.getPath());
				byte[] dataIn = Base64.getDecoder().decode(data);

				dataOut = decrypt(key, dataIn);

				// Write plaintext data
				outputFile = path + "_decrypted.txt";
			}
			else {
				byte[] crack = Base64.getDecoder().decode(data);
				System.out.println("Guess for key: " + getKeyAttack(crack));
			}

			if (outputFile != null) {
				FileOutputStream out = new FileOutputStream(outputFile);
				out.write(dataOut);
				out.close();
				System.out.println("Created File " + outputFile);
			}

		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (NullPointerException ne) {
			ne.printStackTrace();
		}
	}
}
