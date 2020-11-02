package com.cunnie;

public class MaxRangeRecursive {
    static int[] s1Array;
    static int[] s2Array;
    static int[] iArray;
    static int[] jArray;

    private static int[] fitnessSlightlyLessNaive(int[] a, int left, int right) {
        if (right - left <= 4) {
            return fitnessNaive(a, left, right);
        }
        int m = a.length / 2;
        int[] ij1 = fitnessSlightlyLessNaive(a, 0, m);
        int[] ij3 = fitnessSlightlyLessNaive(a, m + 1, a.length - 1);
        int[] ij2 = new int[2];
        ij2[0] = iArray[m]; // i*2
        ij2[1] = iArray[m + 1]; // j*2
        int quality1 = s1Array[ij1[0]] + s2Array[ij1[1]];
        int quality2 = s1Array[ij2[0]] + s2Array[ij2[1]];
        int quality3 = s1Array[ij3[0]] + s2Array[ij3[1]];
        if (quality1 > quality2 && quality1 > quality3) {
            return ij1;
        }
        if (quality2 > quality3) {
            return ij2;
        }
        return ij3;
    }

    private static int[] fitnessNaive(int[] a, int left, int right) {
        int qMax = Integer.MIN_VALUE;
        int[] ij = new int[2];  // i*, j*
        for (int i = left; i < right; i++) {
            int s1 = s1Array[i];
            int s2 = s2Array[i + 1];
            if (s1 + s2 > qMax) {
                qMax = s1 + s2;
                ij[0] = iArray[i]; //i*
                ij[1] = jArray[i + 1]; //j*
            }
        }
        return ij;
    }

    public static int[] getMaximizedRangeRecursive(int[] a) {
        populateStaticArrays(a);
        return fitnessSlightlyLessNaive(a, 0, a.length - 1);
    }

    private static void populateStaticArrays(int[] a) {
        s1Array = new int[a.length];
        s2Array = new int[a.length];
        iArray = new int[a.length];
        jArray = new int[a.length];
        int s1Max = Integer.MIN_VALUE;
        int s2Max = Integer.MIN_VALUE;
        int istar = 0;  // i*
        int s1 = a[0];
        for (int i = 0; i < a.length - 1; i++) {
            if (s1 > s1Max) {
                s1Max = s1;
                istar = i;
            }
            iArray[i] = istar;
            s1Array[i] = s1;
            s1 += a[i + 1];
        }
        int jstar = 0; // j*
        int s2 = a[a.length - 1];
        for (int j = a.length - 1; j > 0; j--) {
            if (s2 > s2Max) {
                s2Max = s2;
                jstar = j;
            }
            jArray[j] = jstar;
            s2Array[j] = s2Max;
            s2 += a[j - 1];
        }
    }
}
