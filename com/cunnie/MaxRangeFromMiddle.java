package com.cunnie;

public class MaxRangeFromMiddle {
    public static int[] getMaximizedRange(int[] a) {
        int iMax = Integer.MIN_VALUE;
        int jMax = Integer.MIN_VALUE;
        final int n = a.length - 1;
        final int m = a.length / 2;
        int[] ij = new int[2];
        int s1 = a[0];
        for (int i = 0; i <= m; i++) {
            if (s1 > iMax) {
                iMax = s1;
                ij[0] = i;
            }
            s1 += a[i + 1];
        }
        int s2 = a[n];
        for (int j = n; j > m; j--) {
            if (s2 > jMax) {
                jMax = s2;
                ij[1] = j;
            }
            s2 += a[j -1];

        }
        System.out.println("i is " + ij[0]);
        System.out.println("j is " + ij[1]);
        return ij;
    }
}
