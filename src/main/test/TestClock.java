package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import clock.Clock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TestClock {
    Clock c1;


    @BeforeEach
    void runBefore() {
        c1 = new Clock();
    }

    public int load() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("outputfile.txt"));
        String s = lines.get(0);
        return Integer.parseInt(s);
    }


    @Test
    void testCountdownNotNegative() throws InterruptedException {
        assertTrue(c1.initial >= 0);
    }

    @Test
    void testCountdownMaxVal() throws InterruptedException {
        assertTrue(c1.initial <= 2147483647);
    }

    @Test
    void testStopwatchBeginsZero() throws InterruptedException {
        assertTrue(c1.initial >= 0);
    }

    @Test
    void testStopwatchLimit() throws InterruptedException {
        assertTrue(c1.initial <= 2147483647);
    }

    @Test
    void testSaveStopwatch() throws IOException {
        c1.save(10);
        assertEquals(10, c1.load());
    }

    @Test
    void testSaveCountdown() throws IOException {
        c1.save(15);
        assertEquals(15, c1.load());
    }

}

