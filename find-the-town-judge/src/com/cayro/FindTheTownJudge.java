package com.cayro;

public class FindTheTownJudge {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] villagers = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        int[][] villagers2 = {{1, 2}};
        int[][] villagers3 = {{1, 3}, {2, 3}};
        int[][] villagers4 = {{1, 3}, {2, 3}, {3, 1}};
        int[][] villagers5 = {{1, 2}, {2, 3}};
        System.out.println("Town judge is: " + solution.findJudge3(2, villagers2));
    }
}
