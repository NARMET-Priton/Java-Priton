package com.WlanKasper;

public class Cavallo extends Thread {
    private final String name;
    private final int handicap;
    private int index;

    public Cavallo(String name, int handicap) {
        this.name = name;
        this.handicap = handicap;
    }

    public void run() {
        for (index = 0; index < 50; index++) {
            try {
                sleep(100 * handicap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getIndexCavallo() {
        return index;
    }

    public String getNameCavallo() {
        return name;
    }

}