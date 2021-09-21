package com.WlanKasper.Business;

import com.WlanKasper.Vigener.Vigener;
import com.WlanKasper.main.Console;

public class Business {

    Vigener vigener = new Vigener();
    Console console = new Console();

    private final String key;
    private boolean run = true;

    public Business(String key) {
        this.key = key;
    }

    public void initCrypto() {

        while (run) {
            String phrase = console.inputString("Initial phrase: ");

            String newKey = vigener.keyAdaptation(phrase, key);

            String encrypted = vigener.encrypt(phrase, newKey);
            console.outputString(encrypted, "Encrypted phrase: ");

            String decrypted = vigener.decrypt(encrypted, newKey);
            console.outputString(decrypted, "Decrypted phrase: ");

            run = console.inputBool("If you want to repute program press 1 or 0 to end: ");
        }
    }
}
