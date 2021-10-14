package com.WlanKasper;

// You must enter in Main Config a key like argument

public class Main {

    public static void main(String[] args) {

        if (args[0].stripIndent() != null || args[0].stripIndent().length() > 0) {
            new Console(args[0]).execute();
        }else {
            new Console().execute();
        }

    }
}
