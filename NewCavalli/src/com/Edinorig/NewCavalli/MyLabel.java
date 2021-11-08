package com.Edinorig.NewCavalli;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//добавити ще 4 коня

public class MyLabel extends JLabel {

    public static final int WIDTHHORSE = 150;
    public static final int HEIGHTHORSE = 150;
    private int positionX = 0;
    private int positionY = 0;

    Border border = BorderFactory.createLineBorder(Color.green);

    MyLabel(int y, String name) {
        positionY = y;
        this.setText(name);
        this.setLayout(new BorderLayout());
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setVerticalTextPosition(JLabel.TOP);
        //this.setVerticalAlignment(JLabel.CENTER);
        // this.setHorizontalAlignment(JLabel.LEFT);
        this.setIcon(scaleImage());
        this.setIconTextGap(10);
        this.setBounds(positionX, positionY, WIDTHHORSE, HEIGHTHORSE);
        this.setBackground(Color.yellow);
        this.setOpaque(true);
        this.setBorder(border);
    }

    private ImageIcon scaleImage() {
        ImageIcon image = new ImageIcon("/Users/denys_vysotskyy/Documents/Local_Project/NewCavalli/src/com/Edinorig/NewCavalli/salo.png");
        Image img = image.getImage();
        Image imScale = img.getScaledInstance(100, 100, 100);
        ImageIcon scaledIcon = new ImageIcon(imScale);
        return scaledIcon;
    }

    public void moveHorse(){
        positionX+=10;
        this.setBounds(positionX, positionY, WIDTHHORSE, HEIGHTHORSE);
    }
}
