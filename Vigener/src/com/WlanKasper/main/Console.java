package com.WlanKasper.main;

import java.util.Scanner;

public class Console {

    Scanner scanner = new Scanner(System.in);

    public String inputString (String instructions) {
        System.out.println(instructions);

        return scanner.nextLine();
    }

    public boolean inputBool (String instructions) {
        System.out.println(instructions);

        return scanner.nextBoolean();
    }

    public void outputString (String phrase, String instructions) {
        System.out.println(instructions + phrase);
    }

}
