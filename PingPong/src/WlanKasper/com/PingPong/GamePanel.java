package WlanKasper.com.PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int) (GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 100;
    static final int PADDLE_HEIGHT = 25;

    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    GameScore score;

    GamePanel () {
        newPaddles();
        newBall();
        score = new GameScore(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall () {
//        random = new Random();
        ball = new Ball(paddle1.x, paddle1.y + BALL_DIAMETER, BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddles () {
        //TOP
        paddle2 = new Paddle(GAME_WIDTH/2 - (PADDLE_WIDTH / 2), 0, PADDLE_WIDTH, PADDLE_HEIGHT, 2);
        // BOT
        paddle1 = new Paddle(GAME_WIDTH/2 - (PADDLE_WIDTH / 2), GAME_HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT, 1);
    }

    public void paint (Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw (Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync(); // I forgot to add this line of code in the video, it helps with the animation
    }

    public void move () {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void checkCollision () {

        if (ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            newBall();

        }

        if (ball.intersects(paddle2)) {
            newBall();
            score.player++;
        }

        //stops paddles at window edges
        if (paddle1.x <= 0) paddle1.x = 0;
        if (paddle1.x >= (GAME_WIDTH - PADDLE_WIDTH)) paddle1.x = GAME_WIDTH - PADDLE_WIDTH;
        if (paddle2.x <= 0) paddle2.x = 0;
        if (paddle2.x >= (GAME_WIDTH - PADDLE_WIDTH)) paddle2.x = GAME_WIDTH - PADDLE_WIDTH;
        //give a player 1 point and creates new paddles & ball
        if (ball.x <= 0) {
            score.player++;

            newPaddles();
            newBall();
            System.out.println("Player 2: " + score.player);
        }

        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            score.player++;
            newPaddles();
            newBall();
            System.out.println("Player 1: " + score.player);
        }
    }

    public void run () {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {

        public void keyPressed (KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        public void keyReleased (KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
