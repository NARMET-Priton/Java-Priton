package WlanKasper.com.PingPong.thread;

import WlanKasper.com.PingPong.GUI.My.MyLabel;

public class TopThread extends Thread {
    MyLabel label;
    public TopThread (MyLabel label) {
        this.label = label;
    }

    @Override
    public void run () {
        label.moveTopEnemy();
    }
}
