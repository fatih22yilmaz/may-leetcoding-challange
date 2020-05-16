package com.cayro;

import java.util.Arrays;

public class Solution {

    public int maxSubarraySumCircular(int[] A) {
        int[] AA = new int[A.length * 2];

        for (int i = 0; i < A.length; i++) {
            AA[i] = A[i];
            AA[i + A.length] = A[i];
        }

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int num : AA) {
            maxEndingHere = Math.max(maxEndingHere + num, num);
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
        }

        return maxSoFar;
    }

    public int maxSubarraySumCircular2(int[] A) {
        int[] AA = new int[A.length * 2];

        for (int i = 0; i < A.length; i++) {
            AA[i] = A[i];
            AA[i + A.length] = A[i];
        }


        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0; left < AA.length; left++) {
            int currentTotal = 0;
            for (int right = left; right < Math.min(left + A.length, AA.length); right++) {
                currentTotal += AA[right];
                if (currentTotal > max) {
                    max = currentTotal;
                    start = left;
                    end = right;
                }
            }
        }

        System.out.println("Maximum sub array is between index: " + start + ", " + end);

        return max;
    }

    public int maxSubarraySumCircular3(int[] A) {

        int kadanes = A[0];
        int sumIncludingCurrent = A[0];

        int kadanesReverse = (A[0] * -1);
        int sumIncludingCurrentReverse = (A[0] * -1);

        int sum = A[0];
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            sumIncludingCurrent = A[i] + Math.max(sumIncludingCurrent, 0);
            kadanes = Math.max(kadanes, sumIncludingCurrent);

            A[i] *= -1;
            sumIncludingCurrentReverse = A[i] + Math.max(sumIncludingCurrentReverse, 0);
            kadanesReverse = Math.max(kadanesReverse, sumIncludingCurrentReverse);
        }
        int circularSum = kadanesReverse + sum;

        if (circularSum != 0 && circularSum > kadanes) {
            return circularSum;
        } else {
            return kadanes;
        }
    }
}
