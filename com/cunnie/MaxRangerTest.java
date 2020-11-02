package com.cunnie;

import static org.junit.jupiter.api.Assertions.*;

class MaxRangerTest {

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWith1Negative() {
        int[] a = new int[]{1, -1, 1};
        int[] r = MaxRanger.getMaximizedRange(a);
        assertEquals(0, r[0]);
        assertEquals(2, r[1]);
    }

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWith3Negatives() {
        int[] a = new int[]{1, 1, -3, 2, -1, -2, 1, 1};
        int[] r = MaxRanger.getMaximizedRange(a);
        assertEquals(1, r[0]);
        assertEquals(6, r[1]);
    }

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWithDisjointNegatives() {
        int[] a = new int[]{3, -7, -5, 3, 2, -4, 2, 2};
        int[] r = MaxRanger.getMaximizedRange(a);
        System.out.println(r[0]);
        System.out.println(r[1]);
        assertEquals(0, r[0]);
        assertEquals(3, r[1]);
    }

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWithLargerDisjointNegatives() {
        int[] a = new int[]{3, -7, -5, 3, 2, -6, 2, 2};
        int[] r = MaxRanger.getMaximizedRange(a);
        System.out.println(r[0]);
        System.out.println(r[1]);
        assertEquals(0, r[0]);
        assertEquals(6, r[1]);
    }

    @org.junit.jupiter.api.Test
    void getMaximizedRangeWithNegativeFirstNumber() {
        int[] a = new int[]{-1, 2, 1, 2, 3};
        int[] r = MaxRanger.getMaximizedRange(a);
        System.out.println(r[0]);
        System.out.println(r[1]);
        assertEquals(-1, r[0]);
        assertEquals(1, r[1]);
    }
}