package clock;

import java.io.IOException;

public interface ClockFN {

    void beginCountdown(int initial) throws InterruptedException, IOException;

    void beginStopwatch(int initial) throws InterruptedException, IOException;

    void clockSetup() throws InterruptedException, IOException;
}
