package com.WlanKasper.GUI.Cavalli;

// Двигать лошадь в потоках
// изменить размеры лейблов для лошадей

public class Main {

    public static void main (String[] args) {

        MyLabel label_0 = new MyLabel(0);
        MyLabel label_1 = new MyLabel(1);
        MyLabel label_2 = new MyLabel(2);

        MyFrame frame = new MyFrame();
        frame.add(label_0);
        frame.add(label_1);
        frame.add(label_2);

        HorseThread thread_0 = new HorseThread("AAA" , HorseThread.MAX_SPEED, label_0);
        HorseThread thread_1 = new HorseThread("BBB" , HorseThread.MID_SPEED, label_1);
        HorseThread thread_2 = new HorseThread("CCC" , HorseThread.MIN_SPEED, label_2);

        thread_0.start();
        thread_1.start();
        thread_2.start();



    }
}