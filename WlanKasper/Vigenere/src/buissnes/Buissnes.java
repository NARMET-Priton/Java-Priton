package buissnes;

import crypto.Vigenere;
import main.Console;

public class Buissnes {
	
	private String key = "";
	private String phrase = "";
	boolean run = true;
	
	public Buissnes(String key){
		this.key = key;
	}
	
	Vigenere vigenere = new Vigenere();
	Console console = new Console();
	
	public void initCrypto() {
		
		while (run) {
			phrase = console.inputString("Initial phrase: ");
			
			String newKey = vigenere.keyAdaptation(phrase, key);
			 
			String encrypted = vigenere.encrypt(phrase, newKey);
			console.outputString(encrypted, "Encrypted phrase: ");
			
			String decrypted = vigenere.decrypt(encrypted, newKey);	
			console.outputString(decrypted, "Decrypted phrase: ");
			
			run = (boolean) console.inputBool("If you whant to repite programm press 1 or 0 to end: ");
		}
		
		
	}
	
	

}
