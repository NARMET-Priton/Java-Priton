package WlanKasper.com.Restaurant;

import WlanKasper.com.Restaurant.Clients.Client;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main (String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Restaurant");
        frame.setSize(1600, 1000);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel[] arrayLabel = new JPanel[25];

        for (int i = 0; i < arrayLabel.length; i++) {
            arrayLabel[i] = new JPanel();
            arrayLabel[i].setLayout(new BorderLayout());
            arrayLabel[i].setBounds(i * 50 + i * 5, 1, 50, 50);
            arrayLabel[i].setBackground(Color.GRAY);
            frame.add(arrayLabel[i]);
            frame.setVisible(true);
        }
        frame.setVisible(true);

        Client[] arrayClient = new Client[25];
        int id = 1;
        while (isFull(arrayClient)) {
            try {
                TimeUnit.MILLISECONDS.sleep((long) 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch ((int) (Math.random() * 2)) {
                case 0:
                    for (int i = 0; i < 25; i++) {
                        if (arrayClient[i] == null) {
                            arrayClient[i] = new Client("client");
                            arrayLabel[i].setBackground(Color.GREEN);
                            id++;
                            break;
                        }
                    }
                    break;
                case 1:

                    while (true) {
                        if (isEmpty(arrayClient)) {
                            break;
                        }
                        int randomID = (int) (Math.random() * 25);
                        System.out.println(randomID);
                        if (arrayClient[randomID] != null) {
                            arrayClient[randomID] = null;
                            arrayLabel[randomID].setBackground(Color.GRAY);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    public static boolean isFull (Client[] arr) {
        for (int i = 0; i < 25; i++) {
            if (arr[i] == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmpty (Client[] arr) {
        for (int i = 0; i < 25; i++) {
            if (arr[i] != null) {
                return false;
            }
        }
        return true;
    }
}