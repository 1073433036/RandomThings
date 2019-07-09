package Cryptography;
// Stream cipher with a dumb PRG
//
// FOR EDUCATIONAL PURPOSES ONLY -- DO NOT USE IN PRODUCTION

import java.io.*;
import java.util.*;
import java.nio.file.Files;

public class stream1dumbFull {

	static final Scanner scan = new Scanner(System.in);

	// --- Dumb PRG
	public static byte[] PRG(byte[] seed, int len) {
		byte[] output = new byte[len];
		for (int i = 0; i < output.length; i++)
			output[i] = seed[i % seed.length];
		return output;
	}

	// --- Stream encryption
	public static byte[] encrypt(String key, byte[] plaintext) {

		// Evaluate the PRG
		byte[] mask = PRG(key.getBytes(), plaintext.length);

		// Add PRG output to plaintext to get ciphertext
		byte[] ciphertext = new byte[plaintext.length];
		for (int i = 0; i < ciphertext.length; i++)
			ciphertext[i] = (byte) (plaintext[i] + mask[i]);

		return ciphertext;
	}

	// --- Stream decryption
	public static byte[] decrypt(String key, byte[] ciphertext) {

		// Evaluate the PRG
		byte[] mask = PRG(key.getBytes(), ciphertext.length);

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
				System.out.print("Key (8 chars): ");
				key = scan.nextLine();
			}
			while (key.length() != 8);

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
