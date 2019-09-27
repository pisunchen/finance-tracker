package ui;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Clock c = new Clock();
        c.select();
        Scanner user = new Scanner(System.in);
        int selection = Integer.parseInt(user.nextLine());

        while (true) {
            if (selection == 1) {
                c.timeCountdown();
                int countdown = Integer.parseInt(user.nextLine());
                c.beginCountdown(countdown);
                break;
            } else if (selection == 2) {
                c.timeStopwatch();
                c.beginStopwatch(0);
                break;
            } else if (selection == 0) {
                break;
            }
        }
    }
}
