package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.Rocket;
import WlanKasper.com.PingPong.Objects.SpaceShip;

import java.awt.*;

public class SpaceShip_Rocket extends Thread {

    private final Rocket rocket;

    public SpaceShip_Rocket (SpaceShip spaceShip) {
        rocket = new Rocket(spaceShip.x - (Rocket.ROCKET_DIAMETER / 2), spaceShip.y - Rocket.ROCKET_DIAMETER);
    }

    @Override
    public void run () {
        super.run();
        while (true) {
            try {
                Thread.sleep(10);
                checkBoards();
                rocket.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void drawRocket (Graphics g) {
        rocket.draw(g);
    }

    public void pushRocket () {
        rocket.setYDirection(-10);
    }

    public boolean isShot (SpaceShip ship) {
        return rocket.intersects(ship);
    }

    public void checkBoards () {
        if (rocket.y < 0) {
            this.interrupt();
        }
    }
}
