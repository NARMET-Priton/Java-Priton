package com.WlanKasper;

public class YesThread extends  Thread{

    int inizio;
    String nome;

    public YesThread(int i, String n){
        inizio = i;
        nome = n;
    }

    public void cicla(){
        for (int i = inizio; i < 30; i++){
            System.out.println(nome+" " + i);
        }
    }

    public void run(){
        for (int i = inizio; i < 30; i++){
            System.out.println(nome+" " + i);
        }
    }
}
