package View;

import javax.swing.*;

public class Ship extends JLabel {

    private static final int PANEL_WIDTH =1000 ;

    int height;
    int width;
    int xVelocity;
    int x = 0;
    int y = 730;

    ImageIcon player;


    Ship() {
        player = new ImageIcon("/Users/denys_vysotskyy/Desktop/LocalProjectinteliJ/GameTP/src/Img/badPerson.jpeg");
        height = player.getIconHeight();
        width = player.getIconWidth();
        this.setBounds(x, y, width, height);
        this.setIcon(player);
        this.setVisible(true);
    }

    public Ship(int yPosition) {
        y = yPosition;
        player = new ImageIcon("/Users/denys_vysotskyy/Desktop/LocalProjectinteliJ/GameTP/src/Img/badPerson.jpeg");
        height = player.getIconHeight();
        width = player.getIconWidth();
        this.setBounds(x, y, width, height);
        this.setIcon(player);
        this.setVisible(true);
    }

    public void moveLeft() {
        x -= 10;
        this.setBounds(x, y, width, height);
    }

    public void moveRight() {
        x += 10;
        this.setBounds(x, y, width, height);
    }

    public void checkBoards() {

        if (x >= PANEL_WIDTH - player.getIconWidth() || x < 0) {
            xVelocity = xVelocity * -1;
        }
        x = x + xVelocity;



        if(x>=PANEL_WIDTH-player.getIconWidth() || x<0) {

            xVelocity = xVelocity * -1;

        }

        x = x + xVelocity;

    }
}



