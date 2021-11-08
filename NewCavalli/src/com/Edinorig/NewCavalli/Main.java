package com.Edinorig.NewCavalli;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        MyFrame myFrame = new MyFrame();

        MyLabel label0 = new MyLabel(0, "Incapsulation");
        MyLabel label1 = new MyLabel(150, "Narmet");
        MyLabel label2 = new MyLabel(300, "Solid");
        MyLabel label3 = new MyLabel(450, "Polimorfism");

        Horse horse0 = new Horse(label0,0);
        Horse horse1 = new Horse(label1,150);
        Horse horse2 = new Horse(label2,300);
        Horse horse3 = new Horse(label3,450);

        myFrame.add(label0);
        myFrame.add(label1);
        myFrame.add(label2);
        myFrame.add(label3);

        horse0.start();
        horse1.start();
        horse2.start();
        horse3.start();

        // label0.setBounds(10*i, 0, 150,150);
        //label1.setBounds(11*i, 150, 150,150);
        // label2.setBounds(11*i, 300, 150,150);
        // label3.setBounds(15*i, 450, 150,150);

    }
}
