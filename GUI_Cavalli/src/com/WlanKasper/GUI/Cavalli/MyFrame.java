package com.WlanKasper.GUI.Cavalli;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(){

        this.setTitle("Cavalli GUI");                                    // Название фрейма
        this.getContentPane().setBackground(Color.GRAY);                 // Изменить фон (default) фрейма
//      frame.getContentPane().setBackground(new Color(123,124,111));    // Изменить фон (RGB) фрейма

        this.setSize(420, 420);  // задать размер по x, y
        this.setResizable(false);             // запретить растягивать фрейм
        this.setVisible(true);                // включить видимость фрейма

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // Завершает работу потока при закрытии фрейма
//      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);    // Завершает работу потока при закрытии фрейма

//      ImageIcon titleLogo = new ImageIcon("/Users/arthursmirnov/Documents/Local-Projects/GUI_Cavalli/img/logo.png");   // создать объект фото
//      frame.setIconImage(titleLogo.getImage());

        // Слишком большой размер img
    }

}
