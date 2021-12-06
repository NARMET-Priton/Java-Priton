package View;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{

    MyPanel myPanel;

    public MyFrame()  {
        myPanel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(myPanel);
        this.pack();
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}

