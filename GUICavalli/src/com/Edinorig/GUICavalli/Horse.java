package com.Edinorig.GUICavalli;

public class Horse extends Thread {

    MyLabel label ;

    int handicap;
    int indexHourse;
    int axisY;

    public Horse(MyLabel l, int y) {
        handicap = (int) (Math.random() * 5);
        label = l;
        axisY = y;
    }

    public void run() {
        for (indexHourse = 0; indexHourse < 100; indexHourse++) {
            System.out.println(Thread.currentThread().getName());   // выводит название работающего потока
             label.setBounds(indexHourse*handicap, axisY, 150,150);
            try {
                Thread.currentThread().sleep(100 * handicap);
            } catch (InterruptedException e) {
                //e.printStackTrace();
                break;
            }
        }
        // при выходе из цикла поток умрет
        //создан -> живой -> ждет <-> работает -> умер
    }
}

