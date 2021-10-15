package com.Edinorig.GUICavalli;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

//добавити ще 4 коня

public class MyLabel extends JLabel {

    ImageIcon image = new ImageIcon("/Users/denys_vysotskyy/Documents/Local_Project/GUICavalli/src/salo.png");
    Image img = image.getImage();
    Image imScale = img.getScaledInstance(200,200,1000);
    ImageIcon scaledIcon = new ImageIcon(imScale);


    MyLabel(){
        this.setText("Hello i am kon");
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        this.setIconTextGap(100);
        this.setIcon(scaledIcon);
    }

}
