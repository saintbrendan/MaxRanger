package com.cunnie;

public class MaxRanger {
    public static int[] getMaximizedRangeX(int[] a) {
        int qMax = Integer.MIN_VALUE;
        final int n = a.length - 1;
        int[] ij = new int[2];
        int s1 = a[0];
        for (int i = 0; i < n - 1; i++) {
            int s2 = a[n];
            for (int j = n; j >= i + 1; j--) {
                if (s1 + s2 > qMax) {
                    qMax = s1 + s2;
                    ij[0] = i;
                    ij[1] = j;
                }
                s2 = s2 + a[j - 1];
            }
            s1 = s1 + a[i + 1];
        }
        System.out.println("i is " + ij[0]);
        System.out.println("j is " + ij[1]);
        return ij;
    }

    public static int[] getMaximizedRange(int[] a) {
        int[] amax = new int[a.length];
        int[] amaxj = new int[a.length];
        int max = Integer.MIN_VALUE;
        int maxj = a.length - 1;
        int rSum = 0;
        for (int j = a.length - 1; j >= 0; j--) {
            rSum += a[j];
            if (rSum > max) {
                max = rSum;
                maxj = j;
            }
            amax[j] = max;
            amaxj[j] = maxj;
        }
        printArray(amax);
        printArray(amaxj);
        int maxTotali = -1;
        int maxTotal = amax[0];
        int lSum = 0;
        for (int i = 0; i < a.length - 1; i++) {
            lSum += a[i];
            if (lSum + amax[i + 1] > maxTotal) {
                maxTotal = lSum + amax[i + 1];
                maxTotali = i;
            }
        }
        return  new int[]{maxTotali, amaxj[maxTotali + 1]};
    }

    private static void printArray(int[] array) {
        for (int i : array
        ) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
