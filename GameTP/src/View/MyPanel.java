package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyPanel extends JPanel {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    private static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);
    Ship player;
    Target xxx;

    MyPanel() {

        player = new Ship();
        xxx = new Target();

        xxx.start();
        this.add(xxx.getShip());
        this.add(player);
        this.addKeyListener(new Move());
        this.setPreferredSize(SCREEN_SIZE);
        this.setFocusable(true);
    }


    class Move extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A)
                player.moveLeft();
            if (e.getKeyCode() == KeyEvent.VK_D)
                player.moveRight();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A)
                player.moveLeft();
            if (e.getKeyCode() == KeyEvent.VK_D)
                player.moveRight();
        }
    }
}
