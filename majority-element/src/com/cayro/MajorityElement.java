package com.cayro;

public class MajorityElement {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] elements = {2, 2, 1, 1, 1, 2, 2};
        int[] elements2 = {3, 2, 3};
        int[] elements3 = {2};
        System.out.println("Majority element is: " + solution.majorityElement3(elements3));
    }
}
