package WlanKasper.com.PingPong.thread;

import WlanKasper.com.PingPong.GUI.My.MyLabel;

public class MidThread extends Thread {
    MyLabel label;
    public MidThread (MyLabel label) {
        this.label = label;
    }

    @Override
    public void run () {
        label.moveMidEnemy();
    }
}
