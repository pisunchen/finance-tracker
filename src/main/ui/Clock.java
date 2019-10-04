package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;


public class Clock implements CountUp, CountDown {

    public int initial = 0;

    public Clock() {
    }

    @Override
    public void select() {
        System.out.print("Press 1 for countdown, 2 for stopwatch, 0 to quit the program, 9 to load the previous");
    }

    @Override
    public void timeCountdown() {
        System.out.print("From what second would you like to countdown? ");
    }

    @Override
    public void timeStopwatch() {
        System.out.print("Stopwatch confirmed, beginning countdown");
    }


    // REQUIRES: countdown cannot reach a negative number
    // MODIFIES: this
    // EFFECTS: Countdowns from the number given by user until reaching 0
    @Override
    public void beginCountdown(int initial) throws InterruptedException, IOException {
        save(initial);
        this.initial = initial;
        while (true) {
            System.out.println(initial + " seconds");
            Thread.sleep(1000);
            initial--;
            if (initial <= -1) {
                break;
            }
        }
    }

    // REQUIRES: value must start from 0 seconds
    // MODIFIES: this
    // EFFECTS: Starts counting at a rate of one second, starting from 0
    @Override
    public void beginStopwatch(int initial) throws InterruptedException, IOException {
        save(initial);
        this.initial = initial;
        while (true) {
            System.out.println(initial + " seconds");
            Thread.sleep(1000);
            initial++;

        }
    }

    @Override
    public void clockSetup() throws InterruptedException, IOException {
        Scanner user = new Scanner(System.in);
        int selection = Integer.parseInt(user.nextLine());
        while (true) {
            if (selection == 1) {
                timeCountdown();
                int countdown = Integer.parseInt(user.nextLine());
                beginCountdown(countdown);
                break;
            } else if (selection == 2) {
                timeStopwatch();
                beginStopwatch(0);
                break;
            } else if (selection == 0) {
                break;
            } else if (selection == 9) {
                load();
            }
        }
    }

    public void save(int saveTime) throws IOException {
        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        writer.println(saveTime);
        writer.close();
    }

    public int load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        String s = lines.get(0);
        return Integer.parseInt(s);

    }
}

