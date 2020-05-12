package com.cayro;

import java.util.*;

public class Solution {
    private int srLength = 0;
    private int scLength = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        srLength = image.length;
        if (srLength <= 0) {
            return image;
        }
        scLength = image[0].length;

        if (scLength <= 0) {
            return image;
        }
        Set<String> pointsSet = new LinkedHashSet<>();
        pointsSet.add(sr + "," + sc);
        int baseColor = image[sr][sc];

        if (baseColor == newColor) {
            return image;
        }

        while (!pointsSet.isEmpty()) {
            String newCoordinates = pointsSet.iterator().next();
            pointsSet.remove(newCoordinates);

            String[] split = newCoordinates.split(",");
            sr = Integer.parseInt(split[0]);
            sc = Integer.parseInt(split[1]);

            image[sr][sc] = newColor;

            updateStack(sr, sc, pointsSet, image, baseColor);
        }

        return image;
    }

    private void updateStack(int sr, int sc, Set<String> pointsSet, int[][] image, int baseColor) {

        String[] availableDirections = {
                (sr - 1) + "," + sc,
                sr + "," + (sc - 1),
                (sr + 1) + "," + sc,
                sr + "," + (sc + 1)};

        //0 => sr - 1 // 1 => sc - 1 // 2 => sr + 1 // 3 => sc + 1

        if (sr - 1 < 0 || image[sr - 1][sc] != baseColor) {
            availableDirections[0] = null;
        }
        if (sc - 1 < 0 || image[sr][sc - 1] != baseColor) {
            availableDirections[1] = null;
        }
        if (sr + 1 >= srLength || image[sr + 1][sc] != baseColor) {
            availableDirections[2] = null;
        }
        if (sc + 1 >= scLength || image[sr][sc + 1] != baseColor) {
            availableDirections[3] = null;
        }

        for (String str : availableDirections) {
            if (Objects.nonNull(str)) {
                pointsSet.add(str);
            }
        }
    }

    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) { //fucking more logical, I really loved it!

        if (image == null || image.length == 0 || image[sr][sc] == newColor) {
            return image;
        }

        int baseColor = image[sr][sc];
        dfsRecursive(image, sr, sc, newColor, baseColor);

        return image;
    }

    private void dfsRecursive(int[][] image, int sr, int sc, int newColor, int baseColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != baseColor) {
            return;
        }

        image[sr][sc] = newColor;
        dfsRecursive(image, sr - 1, sc, newColor, baseColor);
        dfsRecursive(image, sr, sc - 1, newColor, baseColor);
        dfsRecursive(image, sr + 1, sc, newColor, baseColor);
        dfsRecursive(image, sr, sc + 1, newColor, baseColor);

    }
}
