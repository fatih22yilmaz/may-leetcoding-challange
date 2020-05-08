package com.cayro;

public class CheckIfItIsAStraightLine {

    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] coordinates = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
        int[][] coordinates2 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int[][] coordinates3 = {{-3, -2}, {-1, -2}, {2, -2}, {-2, -2}, {0, -2}};

        System.out.println("Is a straight line: " + solution.checkStraightLine(coordinates));
    }
}
