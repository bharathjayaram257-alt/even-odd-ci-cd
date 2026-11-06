package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EvenOddTest {
    @Test
    void positiveEvenNumberIsEven() {
        assertTrue(EvenOdd.isEven(8));
    }

    @Test
    void positiveOddNumberIsOdd() {
        assertFalse(EvenOdd.isEven(7));
    }

    @Test
    void zeroIsEven() {
        assertTrue(EvenOdd.isEven(0));
    }

    @Test
    void negativeEvenNumberIsEven() {
        assertTrue(EvenOdd.isEven(-4));
    }

    @Test
    void negativeOddNumberIsOdd() {
        assertFalse(EvenOdd.isEven(-3));
    }
}
