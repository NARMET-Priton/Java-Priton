package buissnes;

import main.Console;
import vigenere.Vigenere;

public class Buissnes {

	Console console = new Console();
	Vigenere vigenere = new Vigenere();
	
	
	public void init() {
	  String word = console.inputString();
	  String key = console.inputKey();
	  
	  String newKey = vigenere.finalKey(key, word);	  
	  String newEncryption = vigenere.encrypyion(newKey, word);
	  String newDecryption = vigenere.decrypyion(newKey, newEncryption);
	  
	  System.out.println(newKey);
	  System.out.println(newEncryption);
	  System.out.println(newDecryption);
	}
}
