package WlanKasper.com.PingPong;

import WlanKasper.com.PingPong.Threads.SpaceShip_Alien;
import WlanKasper.com.PingPong.Threads.SpaceShip_Battalion;
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

    SpaceShip_Rocket spaceShip_rocket;

    // ---------- Lists ----------
    SpaceShip_Battalion spaceShip_battalion;

    // ---------- Graphics Objects ----------
    Image image;
    Graphics graphics;
    SpaceInvaders_Score spaceInvaders_score;

    public SpaceInvaders_Panel () {
        this.setFocusable(true);
        this.addKeyListener(new KeyListener());
        this.setPreferredSize(SCREEN_SIZE);

        spaceInvaders_score = new SpaceInvaders_Score(SpaceInvaders_Frame.GAME_WIDTH, SpaceInvaders_Frame.GAME_HEIGHT);
        spaceShip_battalion = new SpaceShip_Battalion();

        spaceShip_rocket = new SpaceShip_Rocket();
        spaceShip_rocket.start();
        mainThread = new Thread(this);
        mainThread.start();

        createNewSpaceShip_Player();
        addNewSpaceShip_Alien();
    }

    public void createNewSpaceShip_Player () {
        spaceShip_player = new SpaceShip_Player();
        spaceShip_player.start();
    }

    public void addNewSpaceShip_Alien () {
//        SpaceShip_Alien spaceShip_alien = new SpaceShip_Alien();
//        spaceShip_alien.start();
//        spaceShip_battalion.addNewSpaceShip_Alien(spaceShip_alien);
    }

    public void createNewSpaceShip_Rocket () {
        spaceShip_rocket.addNewRocket(spaceShip_player.getSpaceShip());
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
                break;
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
        if (spaceShip_battalion.getSpaceShips() != null) {
            spaceShip_battalion.draw(g);
        }
        if (spaceShip_rocket != null && spaceShip_rocket.isAlive()) {
            spaceShip_rocket.drawRocket(g);
        }
        spaceInvaders_score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    // ракета после попадания летит дальше
    // если прервать поток то ракету не видно, но она остается в мсте попадания + не создается новая
    public void checkShots () {
        SpaceShip_Alien temp = spaceShip_rocket.isShot(spaceShip_battalion.getSpaceShips());
        if (spaceShip_rocket != null && temp != null) {
            addNewSpaceShip_Alien();
            spaceShip_battalion.killSpaceShip(temp);
            spaceInvaders_score.player++;
        }
    }

    class KeyListener extends KeyAdapter {
        @Override
        public void keyPressed (KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A) {
                spaceShip_player.pressedLeft();
            }
            if (e.getKeyCode() == KeyEvent.VK_D) {
                spaceShip_player.pressedRight();
            }
            if (e.getKeyCode() == KeyEvent.VK_W) {
                createNewSpaceShip_Rocket();
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


