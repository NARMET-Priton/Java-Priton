package main;

import java.util.Scanner;

public class Console {
	
	Scanner scanner = new Scanner(System.in);
	
	public String inputString (String instructions) {
		System.out.println(instructions);
        String str = scanner.nextLine();
        
        return str;
	}
	
	public boolean inputBool (String instructions) {
		System.out.println(instructions);
        boolean bool = scanner.nextBoolean();
        
        return bool;
	}
	
	public void outputString (String phrase, String instructions) {
		System.out.println(instructions + phrase);
	}

}
