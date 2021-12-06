package View;
public class Target extends Thread {

    private Ship ship;


    public Target() {
        ship = new Ship(0);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                Thread.sleep(100);
                ship.checkBoards();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    public Ship getShip() {
        return ship;
    }

}
