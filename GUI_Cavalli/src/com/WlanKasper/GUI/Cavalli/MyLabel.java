package com.WlanKasper.GUI.Cavalli;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// добавить движение лошади

public class MyLabel extends JLabel{

    Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
    ImageIcon imageHorse = new ImageIcon("GUI_Cavalli/img/horse.png");

    private int position = 0;
    private final int numberHorse;

    public MyLabel (int numberHorse) {
        this.numberHorse = numberHorse;
        this.setIcon(imageHorse);
        this.setIconTextGap(0); // отступ между объектами
        this.setBorder(border);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setHorizontalAlignment(JLabel.LEFT);
        this.setBounds(0, imageHorse.getIconHeight() * numberHorse, MyFrame.WIDTH_FRAME, imageHorse.getIconHeight());
    }

    public void moveHorse(){
        position+=10;
        this.setBounds(position, imageHorse.getIconHeight() * numberHorse, MyFrame.WIDTH_FRAME, imageHorse.getIconHeight());
    }


}
