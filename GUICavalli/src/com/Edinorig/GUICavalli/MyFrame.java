package com.Edinorig.GUICavalli;

import javax.swing.*;
import java.awt.*;
//зробити так щоб свині почали рухатись

public class MyFrame extends JFrame {


    public MyFrame(){
        this.setTitle("Hiyeta");
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(125,50,125));
    }

    public void addLabel(JLabel label){
        this.add(label);
    }
}
