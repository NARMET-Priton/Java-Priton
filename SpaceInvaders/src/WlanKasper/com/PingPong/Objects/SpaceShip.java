package WlanKasper.com.PingPong.Objects;

import java.awt.*;

public class SpaceShip extends Rectangle {
    public static final int SPACESHIP_WIDTH = 50;
    public static final int SPACESHIP_HEIGHT = 25;

    private final int id;
    public int xVelocity, yVelocity;

    // ---------- Create new SpaceShip ----------
    public SpaceShip (int x, int y, int id) {
        super(x, y, SPACESHIP_WIDTH, SPACESHIP_HEIGHT);
        this.id = id;
    }

    // ---------- Set Direction of SpaceShip ----------
    public void setXDirection (int xDirection) {
        xVelocity = xDirection;
    }

    // ---------- Move SpaceShip ----------
    public void move () {
        x += xVelocity;
        y += yVelocity;
    }

    public void moveDown () {
        y += SPACESHIP_HEIGHT;
    }

    // ---------- Draw Graphic of SpaceShip ----------
    public void draw (Graphics g) {
        if (id == 1) {
            g.setColor(Color.white);
        } else {
            g.setColor(Color.blue);
        }
        g.fillRect(x, y, width, height);
    }
}