package WlanKasper.com.PingPong.Threads;

import WlanKasper.com.PingPong.Objects.SpaceShip;

import java.awt.*;
import java.util.ArrayList;

public class SpaceShip_Battalion {
    private ArrayList<SpaceShip_Alien> battalion;

    public SpaceShip_Battalion () {
        battalion = new ArrayList<>();
    }

    public void addNewSpaceShip_Alien(SpaceShip_Alien ship){
        battalion.add(ship);
    }

    public void draw(Graphics g){
        for (SpaceShip_Alien ship: battalion) {
            ship.drawSpaceShip(g);
        }
    }

    public ArrayList<SpaceShip_Alien> getSpaceShips (){
        if (battalion.isEmpty()){
            return null;
        }
        else{
            return battalion;
        }
    }

    public void killSpaceShip (SpaceShip_Alien ship){
        for (SpaceShip_Alien elem: battalion) {
            if (elem == ship){
                battalion.remove(elem);
            }
        }
    }
}
