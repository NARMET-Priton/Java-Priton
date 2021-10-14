package com.WlanKasper;

public class Main {

    private static final int[] handicapArr = {1, 5, 10};
    private static boolean play = true;

    public static void main(String[] args) {
        Cavallo cavallo_1 = new Cavallo("1", handicapArr[(int) (Math.random() * 3)]);
        Cavallo cavallo_2 = new Cavallo("2", handicapArr[(int) (Math.random() * 3)]);
        Cavallo cavallo_3 = new Cavallo("3", handicapArr[(int) (Math.random() * 3)]);
        Cavallo cavallo_4 = new Cavallo("4", handicapArr[(int) (Math.random() * 3)]);
        Cavallo cavallo_5 = new Cavallo("5", handicapArr[(int) (Math.random() * 3)]);

        cavallo_1.start();
        cavallo_2.start();
        cavallo_3.start();
        cavallo_4.start();
        cavallo_5.start();

        while (play) {
            System.out.println("[" + cavallo_1.getNameCavallo() + "]" + "-->" + cavallo_1.getIndexCavallo());
            System.out.println("[" + cavallo_2.getNameCavallo() + "]" + "-->" + cavallo_2.getIndexCavallo());
            System.out.println("[" + cavallo_3.getNameCavallo() + "]" + "-->" + cavallo_3.getIndexCavallo());
            System.out.println("[" + cavallo_4.getNameCavallo() + "]" + "-->" + cavallo_4.getIndexCavallo());
            System.out.println("[" + cavallo_5.getNameCavallo() + "]" + "-->" + cavallo_5.getIndexCavallo());

            if (cavallo_1.getIndexCavallo() == 49) {
                System.out.println(cavallo_1.getNameCavallo() + " ha vinto!!!");
                play = false;
            }
            if (cavallo_2.getIndexCavallo() == 49) {
                System.out.println(cavallo_2.getNameCavallo() + " ha vinto!!!");
                play = false;
            }
            if (cavallo_3.getIndexCavallo() == 49) {
                System.out.println(cavallo_3.getNameCavallo() + " ha vinto!!!");
                play = false;
            }
            if (cavallo_4.getIndexCavallo() == 49) {
                System.out.println(cavallo_4.getNameCavallo() + " ha vinto!!!");
                play = false;
            }
            if (cavallo_5.getIndexCavallo() == 49) {
                System.out.println(cavallo_5.getNameCavallo() + " ha vinto!!!");
                play = false;
            }
        }
    }
}