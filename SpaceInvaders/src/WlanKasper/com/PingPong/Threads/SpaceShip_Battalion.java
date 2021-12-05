package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.SpaceShip;

import java.awt.*;
import java.util.ArrayList;

public class SpaceShip_Battalion {
    private ArrayList<SpaceShip_Alien> battalion;

    public SpaceShip_Battalion () {
        battalion = new ArrayList<>();
        createBattalion();
    }

    public void addNewSpaceShip_Alien (SpaceShip_Alien ship) {
        battalion.add(ship);
    }

    public void createBattalion () {
        int x, y = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 5 == 0){
                y += SpaceShip.SPACESHIP_HEIGHT + 10;
            }
            x = (i % 5) * 100 + SpaceShip.SPACESHIP_WIDTH;
            SpaceShip_Alien spaceShip_alien = new SpaceShip_Alien(x, y);
            spaceShip_alien.start();
            addNewSpaceShip_Alien(spaceShip_alien);
        }

    }

    public void draw (Graphics g) {
        for (SpaceShip_Alien ship : battalion) {
            ship.drawSpaceShip(g);
        }
    }

    public ArrayList<SpaceShip_Alien> getSpaceShips () {
        if (battalion.isEmpty()) {
            return null;
        } else {
            return battalion;
        }
    }

    public void killSpaceShip (SpaceShip_Alien ship) {
        for (SpaceShip_Alien elem : battalion) {
            if (elem == ship) {
                elem.getSpaceShip().delete();
            }
        }
    }
}
