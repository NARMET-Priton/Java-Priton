package main;

import java.util.Scanner;

public class Console {
	
	public Console() {
		
	}
	
	Scanner scanner = new Scanner(System.in);

	
	public String inputString(){
		System.out.println("Insert your phrase");
		String str = scanner.nextLine();
		return str;
	}
	
	public String inputKey(){
		System.out.println("Insert your key");
		String key = scanner.nextLine();
		return key;
	}
	
	public void outputResult(String newEncryption, String newDecryption,String newKey) {
		  System.out.println(newKey);
		  System.out.println(newEncryption);
		  System.out.println(newDecryption);
	}
}
