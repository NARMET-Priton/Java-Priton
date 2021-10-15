package com.WlanKasper;

public class Main
{
    public static void main(String[] args)
    {
        Horse horse_1 = new Horse("A", Horse.MID_SPEED);
        Horse horse_2 = new Horse("B", Horse.MAX_SPEED);
        Horse horse_3 = new Horse("C", Horse.MIN_SPEED);
        Horse horse_4 = new Horse("D", Horse.MID_SPEED);
        Horse horse_5 = new Horse("E", Horse.MIN_SPEED);

        horse_1.start();
        horse_2.start();
        horse_3.start();
        horse_4.start();
        horse_5.start();

        do
        {
            if (horse_1.horseGetDistance() == 100 || horse_2.horseGetDistance() == 100 || horse_3.horseGetDistance() == 100 || horse_4.horseGetDistance() == 100 || horse_5.horseGetDistance() == 100)
            {
                System.out.println(horse_1.horseStatus());
                System.out.println(horse_2.horseStatus());
                System.out.println(horse_3.horseStatus());
                System.out.println(horse_4.horseStatus());
                System.out.println(horse_5.horseStatus());
                break;
            }
        } while (horse_1.isAlive() && horse_2.isAlive() && horse_3.isAlive() && horse_4.isAlive() && horse_5.isAlive());

        horse_1.interrupt();
        horse_2.interrupt();
        horse_3.interrupt();
        horse_4.interrupt();
        horse_5.interrupt();

    }
}