package WlanKasper.com.PingPong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    int id;
    int xVelocity;
    int speed = 10;

    Paddle (int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed (KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    setXDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    setXDirection(speed);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setXDirection(-speed);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setXDirection(speed);
                }
                break;
        }
    }

    public void keyReleased (KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setXDirection(0);
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setXDirection(0);
                }
                break;
        }
    }

    public void setXDirection (int xDirection) {
        xVelocity = xDirection;
    }

    public void move () {
        x = x + xVelocity;
    }

    public void draw (Graphics g) {
        if (id == 1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}