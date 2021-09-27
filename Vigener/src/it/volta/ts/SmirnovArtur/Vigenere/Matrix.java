package it.volta.ts.SmirnovArtur.Vigenere;

public class Matrix {

	private static final String ALPH = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя§1234567890-=±!@#$%^&*()_+[]{};:|\"'\\<>/?`~ \n";

	private String[][] matrix;

	//-------------------------------------------------------------------------------

	public Matrix() {

		matrix = new String[ALPH.length()][ALPH.length()];
		initMatrix();
//		show();
	}

	private void initMatrix() {

		for (int idx = 0; idx < ALPH.length(); idx++) {
			for (int idy = 0; idy < ALPH.length(); idy++) {
				matrix[idx][idy] = ALPH.substring((idx + idy) % ALPH.length(),(idx + idy) % ALPH.length() + 1);
			}
		}
	}
	
	//-------------------------------------------------------------------------------

	public String encryption(String phrase, String key) {

		if (phrase != null && key != null){

			String encryptedPhrase[] = new String[phrase.length()];

			for (int index = 0; index < phrase.length(); index++) {
				int indxPhrase = ALPH.indexOf(phrase.substring(index, (index + 1)));
				int indexKey = ALPH.indexOf(key.substring(index % key.length(), index % key.length() + 1));
				encryptedPhrase[index] = matrix[indxPhrase][indexKey];
			}
			return String.join("", encryptedPhrase);
		}
		return null;
	}
	
	public String decryption(String phrase, String key) {

		if (phrase != null && key != null){

			String decryptedPhrase[] = new String[phrase.length()];

			for (int index = 0; index < phrase.length(); index++) {
				int indxPhrase = ALPH.indexOf(phrase.substring(index, (index + 1)));
				int indexKey = ALPH.indexOf(key.substring(index % key.length(), index % key.length() + 1));
				decryptedPhrase[index] = matrix[(indxPhrase - indexKey) < 0 ? ALPH.length() + (indxPhrase - indexKey) : indxPhrase - indexKey ][0];
			}
			return String.join("", decryptedPhrase);
		}
		return null;
	}
	
	//-------------------------------------------------------------------------------

	public void show () {

		for (int idx = 0; idx < ALPH.length(); idx++) {
			for (int idy = 0; idy < ALPH.length(); idy++) {
				System.out.print(matrix[idx][idy]);
			}
			System.out.println("");
		}
	}
}
