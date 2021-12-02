package WlanKasper.com.PingPong;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public static final int GAME_WIDTH = 1000;
    public static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));

    GamePanel panel;

    GameFrame () {
        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
