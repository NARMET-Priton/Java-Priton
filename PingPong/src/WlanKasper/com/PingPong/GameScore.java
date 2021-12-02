package WlanKasper.com.PingPong;

import java.awt.*;

public class GameScore extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player;
    int computer;

    GameScore (int GAME_WIDTH, int GAME_HEIGHT) {
        GameScore.GAME_WIDTH = GAME_WIDTH;
        GameScore.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw (Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 60));
        g.drawLine(0, GAME_HEIGHT / 2, GAME_WIDTH, GAME_HEIGHT / 2);
        g.drawString(String.valueOf(computer / 10) + String.valueOf(computer % 10), 0, (GAME_HEIGHT / 2) - 5);
        g.drawString(String.valueOf(player / 10) + String.valueOf(player % 10), 0, (GAME_HEIGHT / 2) + 50);

    }
}