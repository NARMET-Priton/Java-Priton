package com.Edinorig.NewCavalli;

public class Horse extends Thread {

    MyLabel label ;

    int handicap;
    int indexHourse ;
    int axisY;

    public Horse(MyLabel l, int y) {
        handicap = (int) (Math.random() * 5+1);
        indexHourse = (int) (Math.random() * 5);
        label = l;
        axisY = y;
    }

    public void run() {
        for (indexHourse = 0; indexHourse < 120; indexHourse++) {
            System.out.println(Thread.currentThread().getName());   // выводит название работающего потока
             label.moveHorse();
            try {
                Thread.currentThread().sleep(100 * handicap);
            } catch (InterruptedException e) {
                //e.printStackTrace()
            }
        }
        // при выходе из цикла поток умрет
        //создан -> живой -> ждет <-> работает -> умер
    }
}

