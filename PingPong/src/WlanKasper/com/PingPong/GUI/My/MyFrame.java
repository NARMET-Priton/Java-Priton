package WlanKasper.com.PingPong.GUI.My;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame{
    public final static int PANEL_WIDTH = 1000;
    public final static int PANEL_HEIGHT = 1000;

    public MyFrame () {
        this.setTitle("PING PONG");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(PANEL_WIDTH,PANEL_HEIGHT);
        this.setVisible(true);
        this.setLayout(null);
    }
}
