package com.WlanKasper;

public class NoThread {

    int inizio;
    String nome;

    public NoThread(int i, String n){
        inizio = i;
        nome = n;
    }

    public void cicla(){
        for (int i = inizio; i < 30; i++){
            System.out.println(i);
        }
    }

}
