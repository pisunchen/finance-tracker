package placeholder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner user = new Scanner(System.in);
        select();
        int selection = Integer.parseInt(user.nextLine());

        while (true) {
            if (selection == 1) {
                timeCountdown();
                int countdown = Integer.parseInt(user.nextLine());
                beginCountdown(countdown);
                break;
            } else if (selection == 2) {
                timeStopwatch();
                int stopwatch = Integer.parseInt(user.nextLine());
                beginStopwatch(0);
                break;
            } else if (selection == 0) {
                break;
            }
        }
    }

    static void select() {
        System.out.print("Press 1 for countdown, 2 for stopwatch, 0 to quit the program ");
    }

    static void timeCountdown() {
        System.out.print("From what second would you like to countdown? ");
    }

    static void timeStopwatch() {
        System.out.print("Stopwatch confirmed, press 1 to begin ");
    }

    static void beginCountdown(int countdown) throws InterruptedException {
        while (true) {
            System.out.println(countdown + " seconds");
            Thread.sleep(1000);
            countdown--;
            if (countdown <= -1) {
                break;
            }
        }
    }

    static void beginStopwatch(int initial) throws InterruptedException {
        while (true) {
            System.out.println(initial + " seconds");
            Thread.sleep(1000);
            initial++;
        }
    }
}
