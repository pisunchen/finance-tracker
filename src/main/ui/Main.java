package ui;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Clock c = new Clock();
        c.select();
        c.clockSetup();
    }
}