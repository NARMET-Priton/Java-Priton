package it.volta.ts.SmirnovArtur.Vigenere;

import java.util.Scanner;

public class Console {

	Scanner scanner = new Scanner(System.in);

	private String key;
	private String phrase;

	//-------------------------------------------------------------------------------

	public Console (String key) {
		this.key = key;
		do {
			phrase = inputString("Input phrase: ");
		}while(checkInputStr(phrase));

	}

	public Console () {
		do {
			key = inputString("Input key: ");
		}while(checkInputStr(key));
		
		do {
			phrase = inputString("Input phrase: ");
		}while(checkInputStr(phrase));
		
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

	public boolean checkInputStr(String str) {
		str = str.stripIndent();

		return str == null || str.length() <= 0;
	}

}
