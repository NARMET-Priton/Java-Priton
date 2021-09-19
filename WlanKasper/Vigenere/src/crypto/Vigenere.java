package crypto;

public class Vigenere {
	
	private static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,. ";

	public String encrypt(String phrase, String key) {
		
		char[] temp = new char[phrase.length()];
		int indx = 0;
		
		for (int i = 0; i < phrase.length(); i++) {
			indx = findeLetterInAlph(phrase.charAt(i)) + findeLetterInAlph(key.charAt(i));
			
			if (indx >= alph.length()) {
				temp[i] = alph.charAt(indx - alph.length());
			}else {
				temp[i] = alph.charAt(indx);
			}
		}
				
		String enc = new String (temp);
		return enc;
		
	}

	public String decrypt(final String cipher, final String key) {
		
		char[] temp = new char[cipher.length()];
		int indx = 0;
		
		for (int i = 0; i < cipher.length(); i++) {
			
			indx = findeLetterInAlph(cipher.charAt(i)) - findeLetterInAlph(key.charAt(i));
			
			if (indx < 0) {
				temp[i] = alph.charAt(alph.length() + indx);
			}else {
				temp[i] = alph.charAt(indx);
			}
		}
		
				
		String enc = new String (temp);
		return enc;
	}
	

	public String keyAdaptation(String phrase, String key) {

		String temp = "";

		if (phrase.length() >= key.length()) {
			for (int i = 0; i < (phrase.length() / key.length()); i++){
				temp += key;
			}
			for(int i =0 ;i < (phrase.length() % key.length()); i++ ) {
				temp += key.charAt(i);
			}
		}else {
			for (int i = 0; i < phrase.length(); i++) {
				temp += key.charAt(i);
			}
		}
		
		return temp;
	}
	
	private int findeLetterInAlph (char letter) {
		for (int i = 0; i < alph.length(); i++) {
			if (alph.charAt(i) == letter) {
				return i;
			}
		}
		return 777;
	}

}
