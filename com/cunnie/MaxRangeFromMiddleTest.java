package com.cunnie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxRangeFromMiddleTest {

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWith1Negative() {
        int[] a = new int[]{1, -1, 1};
        int[] r = MaxRangeFromMiddle.getMaximizedRange(a);
        assertEquals(0, r[0]);
        assertEquals(2, r[1]);
    }

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWith3Negatives() {
        int[] a = new int[]{1, 1, -3, 2, -1, -2, 1, 1};
        int[] r = MaxRangeFromMiddle.getMaximizedRange(a);
        assertEquals(1, r[0]);
        assertEquals(6, r[1]);
    }

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWithDisjointNegatives() {
        int[] a = new int[]{3, 7, -6, 3, 2, -6, 2, 2};
        int[] r = MaxRangeFromMiddle.getMaximizedRange(a);
        System.out.println(r[0]);
        System.out.println(r[1]);
        assertEquals(1, r[0]);
        assertEquals(6, r[1]);
    }

}