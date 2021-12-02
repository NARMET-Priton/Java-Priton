package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.Rocket;
import WlanKasper.com.PingPong.Objects.SpaceShip;

import java.awt.*;
import java.util.ArrayList;

public class SpaceShip_Rocket extends Thread {

    private Rocket rocket;
    private final ArrayList<Rocket> pushedRocketList;

    public SpaceShip_Rocket () {
        pushedRocketList = new ArrayList<>();
    }

    public void addNewRocket (SpaceShip spaceShip) {
        rocket = new Rocket(spaceShip.x - (Rocket.ROCKET_DIAMETER / 2), spaceShip.y - Rocket.ROCKET_DIAMETER);
        pushedRocketList.add(rocket);
    }

    @Override
    public void run () {
        super.run();
        while (true) {
            try {
                Thread.sleep(10);
                checkBoards();
                moveRockets();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void moveRockets () {
        for (Rocket element : pushedRocketList) {
            element.move();
        }
    }

    public void drawRocket (Graphics g) {
        for (Rocket element : pushedRocketList) {
            element.draw(g);
        }
    }

    public void pushRocket () {
        rocket.setYDirection(-10);
    }

    public boolean isShot (SpaceShip ship) {
        for (Rocket element : pushedRocketList) {
            if (element.intersects(ship)) {
                return true;
            }
        }
        return false;
    }

    public void checkBoards () {
        for (Rocket element : pushedRocketList) {
            if (element.y < 0) {
                element.delete();
            }
        }

    }
}
