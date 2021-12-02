package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.Rocket;
import WlanKasper.com.PingPong.Objects.SpaceShip;

import java.awt.*;

public class SpaceShip_Player_Rocket extends Thread{

    private Rocket rocket;

    public SpaceShip_Player_Rocket (int xPosition, int yPosition) {
        rocket = new Rocket(xPosition - (Rocket.ROCKET_DIAMETER/2), yPosition - Rocket.ROCKET_DIAMETER);
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
                rocket.remove();
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

    public boolean isHit (SpaceShip ship) {
        if (rocket.intersects(ship)){
            this.interrupt();
            return true;
        }
        return false;
    }

    public void checkBoards () {
        if (rocket.y < 0){
            this.interrupt();
        }
    }
}
