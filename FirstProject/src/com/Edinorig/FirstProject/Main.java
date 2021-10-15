package com.Edinorig.FirstProject;

public class Main {

    public static void main(String[] args) {

        Horse h1 = new Horse("A");
        Horse h2 = new Horse("B");
        Horse h3 = new Horse("C");
        Horse h4 = new Horse("D");
        Horse h5 = new Horse("E");


        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();


        // вывод

        // выключаешь потоки других лошадей


        // 1) сделать вывод лошади победетеля
        // 2) остановить всех лошадей как только выиграет одна из

        // как только один из потоков умрет -> какая-то лошадь прибежала

        while (true) {
            System.out.println("Work");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!h1.isAlive()) {
                System.out.println("WIN!!!!" + h1.getNameHourse());
                break;
            } else if (!h2.isAlive()) {
                System.out.println("WIN!!!!" + h2.getNameHourse());
                break;
            } else if (!h3.isAlive()) {
                System.out.println("WIN!!!!" + h3.getNameHourse());
                break;
            } else if (!h4.isAlive()) {
                System.out.println("WIN!!!!" + h4.getNameHourse());
                break;
            } else if (!h5.isAlive()) {
                System.out.println("WIN!!!!" + h5.getNameHourse());
                break;
            }
        }
        h1.interrupt();
        h2.interrupt();
        h3.interrupt();
        h4.interrupt();
        h5.interrupt();
    }
}