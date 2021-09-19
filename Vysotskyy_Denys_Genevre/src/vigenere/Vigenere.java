package vigenere;

public class Vigenere {

	private static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,. ";


	public String finalKey(String key,String word) {
		char[] newKey = new char[word.length()];

		for (int i = 0; i < word.length(); i++) {
			newKey[i] = key.charAt(i % key.length());
		}
		return new String(newKey);
	}
	public String encrypyion(String key,String word) {
		char[] temp = new char[word.length()];

		for(int i = 0; i < word.length(); i++) {
			int temp1 = finder(word.charAt(i)) + finder(key.charAt(i));

			if(temp1<alph.length()) {
				temp[i] = alph.charAt(temp1);
			}else {
				temp[i] = alph.charAt(temp1 - alph.length());
			}

		}
		return new String(temp);
	}

	public String decrypyion(String key,String word) {
		char[] temp = new char[word.length()];

		for(int i = 0; i < word.length(); i++) {
			int temp1 = finder(word.charAt(i)) - finder(key.charAt(i));

			if(temp1>alph.length()) {
				temp[i] = alph.charAt(temp1);
			}else {
				temp[i] = alph.charAt(temp1 + alph.length());
			}

		}
		return new String(temp);
	}

	private int finder (char str) {
		for (int i = 0; i < alph.length(); i++) {
			if (alph.charAt(i) == str) {
				return i;
			}
		}
		return 404;
	}
}
