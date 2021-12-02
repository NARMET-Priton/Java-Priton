package WlanKasper.com.PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel implements Runnable {

    static final Dimension SCREEN_SIZE = new Dimension(GameFrame.GAME_WIDTH, GameFrame.GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;

    Thread gameThread;
    PaddleThread paddleThread;
    Image image;
    Graphics graphics;
    Paddle paddle, paddleT;
    Ball ball;
    GameScore score;

    GamePanel () {
//        paddleThread = new PaddleThread();
        gameThread = new Thread(this);
//        paddleThread.start();
        gameThread.start();

        newPaddle();
        newBall();
        score = new GameScore(GameFrame.GAME_WIDTH, GameFrame.GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
    }

    public void newBall () {
        ball = new Ball(paddle.x + (Paddle.PADDLE_WIDTH / 2) - (BALL_DIAMETER / 2), paddle.y - 10, BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddle () {
        paddle = new Paddle(GameFrame.GAME_WIDTH / 2 - (Paddle.PADDLE_WIDTH / 2), GameFrame.GAME_HEIGHT - Paddle.PADDLE_HEIGHT, Paddle.PADDLE_WIDTH, Paddle.PADDLE_HEIGHT, 1);
        paddleT = new Paddle(1, 0, Paddle.PADDLE_WIDTH, Paddle.PADDLE_HEIGHT, 2);
        paddleT.setXDirection(5);
    }

    public void paint (Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw (Graphics g) {
        paddle.draw(g);
        paddleT.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void move () {
        paddle.move();
        paddleT.move();
        ball.move();
    }

    public void checkCollision () {

        // Если мяч коснулся панели
        if (ball.intersects(paddleT)) {
            score.player++;
            newPaddle(); // заменить на остановку на секунду панели
            newBall();
            System.out.println("Player: " + score.player);
        }
        // Если мяч не коснулся панели
        if (ball.y <= -BALL_DIAMETER) {
            score.computer++;
            newPaddle(); // заменить на остановку на секунду панели
            newBall();
            System.out.println("Computer: " + score.computer);
        }

        // Если панель у края + мяч
        if (paddle.x <= 0) {
            paddle.x = 0;
            ball.x = Paddle.PADDLE_WIDTH/2 - BALL_DIAMETER/2;
        }
        if (paddle.x >= (GameFrame.GAME_WIDTH - Paddle.PADDLE_WIDTH)) {
            paddle.x = GameFrame.GAME_WIDTH - Paddle.PADDLE_WIDTH;
            ball.x = GameFrame.GAME_WIDTH - Paddle.PADDLE_WIDTH/2- BALL_DIAMETER/2;
        }


        if ((paddleT.x <= 0) || (paddleT.x >= (GameFrame.GAME_WIDTH - Paddle.PADDLE_WIDTH))) {
            paddleT.setXDirection(paddleT.xVelocity * -1);
        }

        if (ball.x >= GameFrame.GAME_WIDTH - BALL_DIAMETER || ball.x <= BALL_DIAMETER){
            ball.setXDirection(-ball.xVelocity);
        }
        if (ball.y > (paddle.y - 10)){
            ball.x = ball.afterX;
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
            paddle.keyPressed(e);
            ball.keyPressed(e);
        }

        public void keyReleased (KeyEvent e) {
            paddle.keyReleased(e);
            ball.keyReleased(e);
        }
    }
}
