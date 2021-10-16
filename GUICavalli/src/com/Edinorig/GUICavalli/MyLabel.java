package com.Edinorig.GUICavalli;

import javax.swing.*;
import java.awt.*;

//добавити ще 4 коня

public class MyLabel extends JLabel {

    public static final int WIDTHHORSE = 150;
    public static final int HEIGHTHORSE = 150;

    MyLabel(int y, String name) {
        this.setText(name);
        this.setLayout(new BorderLayout());
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        //this.setVerticalAlignment(JLabel.CENTER);
        // this.setHorizontalAlignment(JLabel.LEFT);
        this.setIcon(scaleImage());
        this.setIconTextGap(10);
        this.setBounds(0, y, WIDTHHORSE, HEIGHTHORSE);
    }

    private ImageIcon scaleImage() {
        ImageIcon image = new ImageIcon("/Users/denys_vysotskyy/Documents/Local_Project/GUICavalli/src/salo.png");
        Image img = image.getImage();
        Image imScale = img.getScaledInstance(100, 100, 100);
        ImageIcon scaledIcon = new ImageIcon(imScale);
        return scaledIcon;
    }
}
