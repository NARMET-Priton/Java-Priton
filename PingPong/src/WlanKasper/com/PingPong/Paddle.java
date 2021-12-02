package WlanKasper.com.PingPong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle {
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 25;

    int id;
    int xVelocity;
    int speed = 10;

    Paddle (int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(-speed);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(speed);
        }
    }

    public void keyReleased (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            setXDirection(-0);
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            setXDirection(0);
        }
    }

    public void setXDirection (int xDirection) {
        xVelocity = xDirection;
    }

    public void move () {
        x = x + xVelocity;
    }

    public void draw (Graphics g) {
        if (id == 1) g.setColor(Color.blue);
        else g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}