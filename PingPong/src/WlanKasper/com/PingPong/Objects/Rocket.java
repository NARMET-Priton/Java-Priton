package WlanKasper.com.PingPong.Objects;

import java.awt.*;

public class Rocket extends Rectangle {
    public static final int ROCKET_DIAMETER = 20;

    int yVelocity, xVelocity;

    public Rocket (int x, int y) {
        super(x, y, ROCKET_DIAMETER, ROCKET_DIAMETER);
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
        g.setColor(Color.green);
        g.fillOval(x, y, height, width);
    }
}
