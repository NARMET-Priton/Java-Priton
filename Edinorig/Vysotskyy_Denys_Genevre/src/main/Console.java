package main;

import java.util.Scanner;

public class Console {
	
	Scanner scanner = new Scanner(System.in);

	
	public String inputString(){
		System.out.println("Insert your phrase");
		String str = scanner.next();
		return str;
	}
	
	public String inputKey(){
		System.out.println("Insert your key");
		String key = scanner.next();
		return key;
	}
	
	//public void outputMessage(){
	//	System.out.println();
	//}
}
