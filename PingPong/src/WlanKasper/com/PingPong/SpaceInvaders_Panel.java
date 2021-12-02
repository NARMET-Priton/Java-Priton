package WlanKasper.com.PingPong;

import WlanKasper.com.PingPong.Objects.SpaceShip;
import WlanKasper.com.PingPong.Threads.SpaceShip_Alien;
import WlanKasper.com.PingPong.Threads.SpaceShip_Player;
import WlanKasper.com.PingPong.Threads.SpaceShip_Rocket;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SpaceInvaders_Panel extends JPanel implements Runnable {

    // ---------- STATIC ----------
    private static final Dimension SCREEN_SIZE = new Dimension(SpaceInvaders_Frame.GAME_WIDTH, SpaceInvaders_Frame.GAME_HEIGHT);

    // ---------- Threads ----------
    Thread mainThread;
    SpaceShip_Player spaceShip_player;
    SpaceShip_Alien spaceShip_alien;
    SpaceShip_Rocket spaceShip_rocket;


    // ---------- Graphics Objects ----------
    Image image;
    Graphics graphics;
    SpaceInvaders_Score spaceInvaders_score;

    public SpaceInvaders_Panel () {
// ---------- JPanel Settings ----------
        this.setFocusable(true);
        this.addKeyListener(new MoveListener());
        this.setPreferredSize(SCREEN_SIZE);

// ---------- Score ----------
        spaceInvaders_score = new SpaceInvaders_Score(SpaceInvaders_Frame.GAME_WIDTH, SpaceInvaders_Frame.GAME_HEIGHT);

// ---------- Main Tread ----------
        mainThread = new Thread(this);
        mainThread.start();

// ---------- SpaceShip Tread of Player ----------
        createNewSpaceShip_Player();

// ---------- SpaceShip Tread of Alien ----------
        createNewSpaceShip_Alien();
    }

    public void createNewSpaceShip_Player () {
        spaceShip_player = new SpaceShip_Player();
        spaceShip_player.start();
    }

    public void createNewSpaceShip_Alien () {
        spaceShip_alien = new SpaceShip_Alien();
        spaceShip_alien.start();
    }

    public void createNewSpaceShip_Rocket (SpaceShip spaceShip){
        spaceShip_rocket = new SpaceShip_Rocket(spaceShip);
        spaceShip_rocket.start();
        spaceShip_rocket.pushRocket();
    }

    @Override
    public void run () {
        while (true) {
            try {
                Thread.sleep(10);
                checkShots();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint (Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw (Graphics g) {
        spaceShip_player.drawSpaceShip(g);
        if (spaceShip_alien != null && spaceShip_alien.isAlive()){
            spaceShip_alien.drawSpaceShip(g);
        }
        if (spaceShip_rocket != null && spaceShip_rocket.isAlive()){
            spaceShip_rocket.drawRocket(g);
        }
        spaceInvaders_score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void checkShots(){
        if (spaceShip_rocket != null && spaceShip_rocket.isShot(spaceShip_alien.getSpaceShip())){
            spaceShip_alien.interrupt();
            spaceInvaders_score.player++;
            createNewSpaceShip_Alien();
        }
    }

    class MoveListener extends KeyAdapter {

        @Override
        public void keyPressed (KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                spaceShip_player.pressedLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                spaceShip_player.pressedRight();
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                createNewSpaceShip_Rocket(spaceShip_player.getSpaceShip());
            }
        }

        @Override
        public void keyReleased (KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                spaceShip_player.releasedLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                spaceShip_player.releasedRight();
            }
        }
    }
}


