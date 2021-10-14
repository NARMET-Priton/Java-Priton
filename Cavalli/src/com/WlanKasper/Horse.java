package com.WlanKasper;

public class Horse extends Thread {

    public static final int MAX_SPEED = 10;
    public static final int MID_SPEED = 5;
    public static final int MIN_SPEED = 1;

    private final String name;
    private final int speed;
    private int distance;

    public Horse(String name, int speed)
    {
        this.name = name;
        this.speed = speed;
    }


    @Override
    public void run()
    {
        for (distance = 0; distance < 100; distance++)
        {
            System.out.println(distance + " " + Thread.currentThread().getName());
            try
            {
                sleep(1000 / speed);
            } catch (InterruptedException e)
            {
                break;
            }
        }
    }

    public String horseStatus()
    {
        return "Name: " + name + "\n" + "Speed: " + speed + "\n" + "Distance: " + distance + "\n";
    }

    public int horseGetDistance()
    {
        return distance;
    }
}
