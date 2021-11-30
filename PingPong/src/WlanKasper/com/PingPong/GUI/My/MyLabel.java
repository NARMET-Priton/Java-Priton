package WlanKasper.com.PingPong.GUI.My;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLabel extends JLabel {
    Image enemy;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    int width, height;

    public MyLabel (Image img) {
        this.setVisible(true);
        enemy = img;
        width = this.getWidth();
        height = this.getHeight();
    }

    public void moveManuallyEnemy(int direction) {
        this.setLocation(this.getX()+10*direction, this.getY());
    }

    public void moveTopEnemy() {
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (x >= MyFrame.PANEL_WIDTH - enemy.getWidth(null) || x < 0) {
                    xVelocity = xVelocity * -1;
                }
                x = x + xVelocity;
                repaint();
            }
        });
        timer.start();
    }

    public void moveMidEnemy() {
        y = 500;
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                if (y >= 600 - enemy.getHeight(null) || y < 0) {
                    yVelocity = yVelocity * -1;
                }
                y = y + yVelocity;
                repaint();
            }
        });
        timer.start();
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(enemy, x, y, null);
    }
}
