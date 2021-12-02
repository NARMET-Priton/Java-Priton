package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.SpaceShip;
import WlanKasper.com.PingPong.SpaceInvaders_Frame;

import java.awt.*;

public class SpaceShip_Player extends Thread {

    private SpaceShip spaceShip;
    private SpaceShip_Player_Rocket rocket;

    public SpaceShip_Player () {
        spaceShip = new SpaceShip(SpaceInvaders_Frame.GAME_WIDTH / 2, SpaceInvaders_Frame.GAME_HEIGHT - SpaceShip.SPACESHIP_HEIGHT, 1);
    }

    @Override
    public void run () {
        super.run();
        while (true) {
            try {
                Thread.sleep(10);
                checkBoards();
                spaceShip.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void drawSpaceShip (Graphics g) {
        spaceShip.draw(g);
        if (rocket != null) {
            rocket.drawRocket(g);
        }
    }

    public void pushRocket () {
        rocket = new SpaceShip_Player_Rocket(spaceShip.x + (SpaceShip.SPACESHIP_WIDTH / 2), spaceShip.y);
        rocket.start();
        rocket.pushRocket();
    }

    public void pressedLeft () { spaceShip.setXDirection(-10); }

    public void pressedRight () {
        spaceShip.setXDirection(10);
    }

    public void releasedLeft () {
        spaceShip.setXDirection(-0);
    }

    public void releasedRight () {
        spaceShip.setXDirection(0);
    }

    public void checkBoards () {
        if (spaceShip.x < 0) {
            spaceShip.x = 0;
        }
        if (spaceShip.x > SpaceInvaders_Frame.GAME_WIDTH - spaceShip.SPACESHIP_WIDTH) {
            spaceShip.x = SpaceInvaders_Frame.GAME_WIDTH - spaceShip.SPACESHIP_WIDTH;
        }
    }

    public SpaceShip_Player_Rocket getRocket () {
        return rocket;
    }

}
