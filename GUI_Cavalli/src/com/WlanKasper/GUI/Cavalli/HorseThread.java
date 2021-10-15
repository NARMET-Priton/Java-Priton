package com.WlanKasper.GUI.Cavalli;

public class HorseThread extends Thread{

    public static final int MAX_SPEED = 10;
    public static final int MID_SPEED = 5;
    public static final int MIN_SPEED = 1;

    private final String name;
    private final int speed;
    private int distance;

    MyLabel label;

    public HorseThread(String name, int speed, MyLabel label)
    {
        this.name = name;
        this.speed = speed;
        this.label = label;
    }

    public void run()
    {
        for (distance = 0; distance < 100; distance++)
        {
            label.moveHorse();
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
