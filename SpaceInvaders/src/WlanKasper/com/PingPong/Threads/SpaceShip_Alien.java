package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.SpaceShip;
import WlanKasper.com.PingPong.SpaceInvaders_Frame;

import java.awt.*;

public class SpaceShip_Alien extends Thread {

    private final SpaceShip spaceShip;
    private final int direction = (int) (1 - Math.random() * 3) == 0 ? 1 : -1;

    public SpaceShip_Alien (int x, int y) {
        spaceShip = new SpaceShip(x, y, 2);
        spaceShip.setXDirection(direction);
    }

    @Override
    public void run () {
        super.run();

        while (true) {
            try {
                Thread.sleep(10);
                spaceShip.move();
                checkBoards();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public void drawSpaceShip (Graphics g) {
        spaceShip.draw(g);
    }

    public void checkBoards () {
        if (spaceShip.x < 0 || spaceShip.x > SpaceInvaders_Frame.GAME_WIDTH - SpaceShip.SPACESHIP_WIDTH) {
            spaceShip.setXDirection(spaceShip.xVelocity * -1);
            spaceShip.moveDown();
        }
    }

    public SpaceShip getSpaceShip () {
        return spaceShip;
    }
}
