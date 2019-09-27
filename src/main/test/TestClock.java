package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Clock;

import static org.junit.jupiter.api.Assertions.assertTrue;


class TestClock {
    Clock c1;

    @BeforeEach
    void runBefore() {
        c1 = new Clock();
    }

    @Test
    void testCountdownNotNegative() throws InterruptedException {
        assertTrue(c1.countdown >= 0);
    }

    @Test
    void testCountdownMaxVal() throws InterruptedException {
        assertTrue(c1.countdown <= 2147483647);
    }

    @Test
    void testStopwatchBeginsZero() throws InterruptedException {
        assertTrue(c1.initial >= 0);
    }

    @Test
    void testStopwatchLimit() throws InterruptedException {
        assertTrue(c1.initial <= 2147483647);
    }


}

