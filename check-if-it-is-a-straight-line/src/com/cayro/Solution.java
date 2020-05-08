package com.cayro;

public class Solution {

    private int x1;
    private int y1;

    public boolean checkStraightLine(int[][] coordinates) {
        x1 = coordinates[0][0];
        y1 = coordinates[0][1];

        double slope = calculateSlope(coordinates[1][0], coordinates[1][1]);

        for (int i = 2; i < coordinates.length; i++) {
            double currentSlope = calculateSlope(coordinates[i][0], coordinates[i][1]);

            if (currentSlope != slope) {
                return false;
            }
        }

        return true;
    }

    private double calculateSlope(int x2, int y2) {

        double dividend = y2 - y1;
        int divisor = x2 - x1;

        if (divisor == 0 && dividend >= 0) {
            return Double.POSITIVE_INFINITY;
        } else if (divisor == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        return dividend / divisor;
    }
}
