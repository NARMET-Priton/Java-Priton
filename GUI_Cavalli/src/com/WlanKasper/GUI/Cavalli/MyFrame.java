package com.WlanKasper.GUI.Cavalli;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public static final int WIDTH_FRAME = 1001;
    public static final int HEIGHT_FRAME = 651;

    public MyFrame(){
        this.setTitle("Cavalli GUI");
        this.getContentPane().setBackground(Color.GRAY);
        this.setSize(WIDTH_FRAME, HEIGHT_FRAME);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
