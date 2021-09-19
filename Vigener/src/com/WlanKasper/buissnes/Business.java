package com.WlanKasper.buissnes;

import com.WlanKasper.main.Console;
import com.WlanKasper.vigener.*;

public class Business {

    private final String key;
    boolean run = true;

    public Business(String key){
        this.key = key;
    }

    Vigener vigener = new Vigener();
    Console console = new Console();

    public void initCrypto() {

        while (run) {
            String phrase = console.inputString("Initial phrase: ");

            String newKey = vigener.keyAdaptation(phrase, key);

            String encrypted = vigener.encrypt(phrase, newKey);
            console.outputString(encrypted, "Encrypted phrase: ");

            String decrypted = vigener.decrypt(encrypted, newKey);
            console.outputString(decrypted, "Decrypted phrase: ");

            run = console.inputBool("If you want to restart program press 1 or 0 to end: ");
        }
    }
}
