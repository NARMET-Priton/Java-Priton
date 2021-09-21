package com.WlanKasper;

public class Main {

    public static void main(String[] args) {

//        NoThread a = new NoThread(0, "Primo");
//        NoThread b = new NoThread(4, "Secondo");
//        NoThread c = new NoThread(9, "Terzo");
//
//        a.cicla();
//        b.cicla();
//        c.cicla();

        YesThread a = new YesThread(0, "Primo");
        YesThread b = new YesThread(4, "Secondo");
        YesThread c = new YesThread(9, "Terzo");

        a.start();
        b.start();
        c.start();

    }
}
