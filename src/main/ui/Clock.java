package ui;

public class Clock {
    public int countdown = 0;
    public int initial = 0;

    public Clock() {
    }

    public void select() {
        System.out.print("Press 1 for countdown, 2 for stopwatch, 0 to quit the program ");
    }

    public void timeCountdown() {
        System.out.print("From what second would you like to countdown? ");
    }

    public void timeStopwatch() {
        System.out.print("Stopwatch confirmed, press 1 to begin ");
    }


    // REQUIRES: countdown cannot reach a negative number
    // MODIFIES: this
    // EFFECTS: Countdowns from the number given by user until reaching 0
    public void beginCountdown(int countdown) throws InterruptedException {
        this.countdown = countdown;
        while (true) {
            System.out.println(countdown + " seconds");
            Thread.sleep(1000);
            countdown--;
            if (countdown <= -1) {
                break;
            }
        }
    }

    // REQUIRES: value must start from 0 seconds
    // MODIFIES: this
    // EFFECTS: Starts counting at a rate of one second, starting from 0
    public void beginStopwatch(int initial) throws InterruptedException {
        this.initial = initial;
        while (true) {
            System.out.println(initial + " seconds");
            Thread.sleep(1000);
            initial++;

        }
    }
}

//    public void pomodoro (int timer, int interval) {
//        this.timer = timer;
//        this.interval = interval;
//        while (true) {
//    }
//  public int timer = 0;
//  public int interval = 0;
//}