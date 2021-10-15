package com.Edinorig.FirstProject;

import java.util.concurrent.TransferQueue;

public class Horse extends Thread {

    String nameHourse;
    int handicap;
    int indexHourse;

    public Horse(String name) {
        handicap = (int) (Math.random() * 5);
        nameHourse = name;
    }


    public void run() {
        for (indexHourse = 0; indexHourse < 50; indexHourse++) {
            System.out.println(Thread.currentThread().getName());   // выводит название работающего потока
            try {
                Thread.currentThread().sleep(100 * handicap);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                break;
            }
        }
        // при выходе из цикла поток умрет
        //создан -> живой -> ждет <-> работает -> умер
    }

    public String getNameHourse() {
        return nameHourse;
    }

    public int getIndexHourse() {
        return indexHourse;
    }
}
