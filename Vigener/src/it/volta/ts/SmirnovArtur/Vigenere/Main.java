package it.volta.ts.SmirnovArtur.Vigenere;

public class Main {

    public static void main(String[] args) {
    	
    	if (args[0].stripIndent() != null || args[0].stripIndent().length() > 0) {
    		new Console(args[0]).execute();
    	}else {
    		new Console().execute();
    	}

    }
}