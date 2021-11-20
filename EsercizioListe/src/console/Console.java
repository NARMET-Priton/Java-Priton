package console;

import business.Elemento;
import dati.ElementoList;

import java.util.Scanner;

public class Console {

    Elemento elemento =null;
    Scanner scanner = new Scanner(System.in);

    private void outputMsg() {
        System.out.println("Program created by Denys Vysotskyy");
        System.out.println("Aplicativo: Esercizio Liste");
    }

    public String inputString() {
        System.out.println("Input string :");
        return scanner.next();
    }

    public void init() {
        ElementoList elementoList = new ElementoList();
        for(int i = 0; i < 5 ;i++){
            elemento = new Elemento(inputString(),inputString());
            elementoList.addToList(elemento);
            System.out.println(elementoList.outputList());
        }
    }
}
