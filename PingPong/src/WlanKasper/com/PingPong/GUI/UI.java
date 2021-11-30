package WlanKasper.com.PingPong.GUI;

import WlanKasper.com.PingPong.GUI.My.MyFrame;
import WlanKasper.com.PingPong.GUI.My.MyLabel;
import WlanKasper.com.PingPong.GUI.My.MyPanel;
import WlanKasper.com.PingPong.thread.MidThread;
import WlanKasper.com.PingPong.thread.TopThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UI implements KeyListener{
    MyFrame frame;
    MyPanel topPanel, midPanel, botPanel;
    MyLabel topLabel, midLabel, botLabel;
    Image topEnemy, midEnemy, botEnemy;
    TopThread topThread;
    MidThread midThread;

    public UI () {
        frame = new MyFrame();
        frame.addKeyListener(this);

        topPanel = new MyPanel();
        midPanel = new MyPanel();
        botPanel = new MyPanel();

        topEnemy = new ImageIcon("/Users/arthursmirnov/Documents/Git/NAMRET-Priton/Java-Priton/PingPong/src/img/pacman.png").getImage();
        midEnemy = new ImageIcon("/Users/arthursmirnov/Documents/Git/NAMRET-Priton/Java-Priton/PingPong/src/img/stell.png").getImage();
        botEnemy = new ImageIcon("/Users/arthursmirnov/Documents/Git/NAMRET-Priton/Java-Priton/PingPong/src/img/enemy.png").getImage();

        topLabel = new MyLabel(topEnemy);
        midLabel = new MyLabel(midEnemy);
        botLabel = new MyLabel(botEnemy);

        topThread = new TopThread(topLabel);
        midThread = new MidThread(midLabel);
    }

    public void initGUI () {
        topPanel.setBounds(0, 0, MyFrame.PANEL_WIDTH, topEnemy.getHeight(null));
        botPanel.setBounds(0, 600, MyFrame.PANEL_WIDTH, botEnemy.getHeight(null));
        midPanel.setBounds(botLabel.getX()+45, 0, midEnemy.getWidth(null),600);

        topLabel.setBounds(0,0,topPanel.getWidth(), topPanel.getHeight());
        midLabel.setBounds(0,0,midPanel.getWidth(), midPanel.getHeight());
        botLabel.setBounds(0,0,botPanel.getWidth(), botPanel.getHeight());

        topPanel.add(topLabel);
        midPanel.add(midLabel);
        botPanel.add(botLabel);

        frame.add(topPanel);
        frame.add(midPanel);
        frame.add(botPanel);

        topThread.start();
        frame.repaint();
    }

    @Override
    public void keyTyped (KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                botLabel.moveManuallyEnemy(-1);
                break;

            case 'd':
                botLabel.moveManuallyEnemy(1);
                break;

            case 'w':
                midPanel.setBounds(botLabel.getX()+45, 230, midEnemy.getWidth(null),370);
                midThread.start();
                break;

            default:
                break;
        }
    }

    @Override
    public void keyPressed (KeyEvent e) {
        switch (e.getKeyCode()) {
            case 37:
                botLabel.moveManuallyEnemy(-1);
                break;

            case 40:
                botLabel.moveManuallyEnemy(1);
                break;

            case 38:
                // nothing
                break;

            default:
                break;
        }
    }

    @Override
    public void keyReleased (KeyEvent e) {

    }
}
