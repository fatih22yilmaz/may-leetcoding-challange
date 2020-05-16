package com.cayro;

public class MaximumSumCircularSubarray {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] A = new int[]{1, -2, 3, -2};
        int[] AInverse = new int[]{-1, 2, -3, 2};
        int[] A2 = new int[]{5, -3, 5};
        int[] A3 = new int[]{1, -2, 3, -2};
        int[] A4 = new int[]{1, -2, 3, -2};
        int[] A5 = new int[]{-2, -3, -1};
        System.out.println("Maximum sum of circular subarray: " + solution.maxSubarraySumCircular3(A5));
    }
}
