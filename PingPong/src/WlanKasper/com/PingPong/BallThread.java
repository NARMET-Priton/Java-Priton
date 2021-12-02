package WlanKasper.com.PingPong;

public class BallThread extends Thread{

    Ball ball;
    public BallThread (int xPaddle, int yPaddle) {
        ball = new Ball(xPaddle + (Paddle.PADDLE_WIDTH / 2) - (Ball.BALL_DIAMETER / 2), yPaddle - 10, Ball.BALL_DIAMETER, Ball.BALL_DIAMETER);
    }

    @Override
    public void run () {
        super.run();

    }

    public Ball getBall () {
        return ball;
    }
}
