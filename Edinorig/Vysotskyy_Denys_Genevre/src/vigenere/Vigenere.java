package vigenere;

public class Vigenere {

	private static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,. ";

	public Vigenere() {

	}

	public String finalKey(String key,String phrase) {
		char[] newKey = new char[phrase.length()];

		for (int i = 0; i < phrase.length(); i++) {
			newKey[i] = key.charAt(i % key.length());
		}
		return new String(newKey);
	}


}
