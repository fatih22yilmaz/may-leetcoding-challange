package com.cayro;

public class SingleElementInASortedArray {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] numbers = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        int[] numbers2 = new int[]{3, 3, 7, 7, 10, 11, 11};
        int[] numbers3 = new int[]{1, 3, 3, 7, 7, 11, 11};
        int[] numbers4 = new int[]{1, 3, 3, 7, 7, 10, 10, 11, 11};
        int[] numbers5 = new int[]{3, 3, 7, 7, 10, 10, 11, 11, 12};
        int[] numbers6 = new int[]{1, 1, 2};
        int[] numbers7 = new int[]{2, 1, 1};
        System.out.println("Single element is: " + solution.singleNonDuplicate4(numbers5));
    }
}
