package it.volta.ts.SmirnovArtur.Vigenere;

import java.util.Scanner;

public class Console {

	Scanner scanner = new Scanner(System.in);
	
	private String key = "";
	private String phrase = "";

	//-------------------------------------------------------------------------------
	
	public Console (String key) {
		this.key = key;
		phrase = inputString("Input phrase: ");
	}

	public Console () {
		key = inputString("Input key: ");
		phrase = inputString("Input phrase: ");
	}
	
	//-------------------------------------------------------------------------------

	public void execute() {
		Matrix matrix = new Matrix();

		String encryptedPhrase = matrix.encryption(phrase, key);
		String decryptedPhrase = matrix.decryption(encryptedPhrase, key);
		
		outputString(phrase, "Initial phrase: ");
		outputString(encryptedPhrase, "Encrypted phrase: ");
		outputString(decryptedPhrase, "Decrypted phrase: ");
	}
	
	//-------------------------------------------------------------------------------

	public String inputString (String instructions) {
		System.out.println(instructions);

		return scanner.nextLine();
	}

	public void outputString (String phrase, String instructions) {
		System.out.println(instructions + phrase);
	}

}
