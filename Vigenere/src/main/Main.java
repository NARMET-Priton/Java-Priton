package main;

import buissnes.Buissnes;

public class Main {

	public static void main(String[] args) {
		
		Buissnes buis = new Buissnes(args[0]);
		
		buis.initCrypto();

	}

}
