package WlanKasper.com.PingPong;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Ball extends Rectangle {
    int yVelocity, xVelocity;
    int speed = 5;
    int afterX;
    boolean canMove = true;

    Ball (int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void setXDirection (int xDirection) {
        xVelocity = xDirection;
    }

    public void setYDirection (int yDirection) {
        yVelocity = yDirection;
    }

    public void move () {
        x = x + xVelocity;
        y = y + yVelocity;
    }

    public void draw (Graphics g) {
        g.setColor(Color.white);
        g.fillOval(x, y, height, width);
    }

    public void keyPressed (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A && canMove) {
            setXDirection(-10);
        }
        else if (e.getKeyCode() == KeyEvent.VK_D && canMove) {
            setXDirection(10);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(-speed);
            canMove = false;
        }

    }

    public void keyReleased (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A && canMove) {
            setXDirection(-0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_D && canMove) {
            setXDirection(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(-speed);
            canMove = false;
        }
    }
}
