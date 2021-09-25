package it.volta.ts.SmirnovArtur.Vigenere;

public class Main {

    public static void main(String[] args) {
    	
    	if (args[0] != null || args[0].length() > 0) {
    		new Console(args[0]).execute();
    	}else {
    		new Console().execute();
    	}

    }
}

