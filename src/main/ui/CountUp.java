package ui;

import java.io.IOException;

public interface CountUp {
    void select();

    void timeCountdown();

    void timeStopwatch();

    void beginCountdown(int initial) throws InterruptedException, IOException;

    void beginStopwatch(int initial) throws InterruptedException, IOException;

    void clockSetup() throws InterruptedException, IOException;
}
