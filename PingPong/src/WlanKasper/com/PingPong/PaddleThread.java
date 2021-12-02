package WlanKasper.com.PingPong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class PaddleThread extends Thread {
    Paddle paddle;
    Graphics graphics;

    public PaddleThread (Graphics g) {
        graphics = g;
        paddle = new Paddle(0, 0, Paddle.PADDLE_WIDTH, Paddle.PADDLE_HEIGHT, 2);
        paddle.setXDirection(5);
    }

    @Override
    public void run () {
        paddle.draw(graphics);
        controll();
        paddle.move();
    }

    public Paddle getPaddle () {
        return paddle;
    }

    public void controll(){

    }

}


