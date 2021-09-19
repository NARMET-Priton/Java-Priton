package com.WlanKasper.vigener;

public class Vigener {

    private static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz,. ";

    public String encrypt(String phrase, String key) {

        char[] temp = new char[phrase.length()];
        int index;

        for (int i = 0; i < phrase.length(); i++) {
            index = findLetterInAlph(phrase.charAt(i)) + findLetterInAlph(key.charAt(i));

            if (index >= alph.length()) {
                temp[i] = alph.charAt(index - alph.length());
            }else {
                temp[i] = alph.charAt(index);
            }
        }

        return new String (temp);

    }

    public String decrypt(final String cipher, final String key) {

        char[] temp = new char[cipher.length()];
        int index;

        for (int i = 0; i < cipher.length(); i++) {

            index = findLetterInAlph(cipher.charAt(i)) - findLetterInAlph(key.charAt(i));

            if (index < 0) {
                temp[i] = alph.charAt(alph.length() + index);
            }else {
                temp[i] = alph.charAt(index);
            }
        }

        return new String (temp);
    }


    public String keyAdaptation(String phrase, String key) {
        char[] newKey = new char[phrase.length()];

        for (int i = 0; i < phrase.length(); i++) {
            newKey[i] = key.charAt(i % key.length());
        }
        return new String(newKey);
    }

    private int findLetterInAlph(char letter) {
        for (int i = 0; i < alph.length(); i++) {
            if (alph.charAt(i) == letter) {
                return i;
            }
        }
        return 777;
    }

}
