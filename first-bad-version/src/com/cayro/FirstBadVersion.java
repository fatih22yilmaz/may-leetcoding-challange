package com.cayro;

public class FirstBadVersion {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long startTime = System.nanoTime();
        System.out.println("First bad version is: " + solution.firstBadVersion2(2_147_483_647));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Counter: " + Solution.counter + " time elapsed: " + (elapsedTime / 1_000_000));
    }
}
