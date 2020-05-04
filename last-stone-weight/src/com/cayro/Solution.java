package com.cayro;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int lastStoneWeight(int[] stones) {

        List<Integer> sortedList = Arrays.stream(stones).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        while (sortedList.size() > 1) {
            Integer elem1 = sortedList.remove(0);
            Integer elem2 = sortedList.remove(0);

            int result = elem1 - elem2;
            if (result > 0) {
                sortedList.add(result);
                sortedList.sort(Comparator.reverseOrder());
            }
        }

        return sortedList.isEmpty() ? 0 : sortedList.get(0);
    }

    public int lastStoneWeight2(int[] stones) {
        Arrays.sort(stones);
        int lastIndex = stones.length - 1;
        int previousIndexThanLast = lastIndex - 1;

        while (stones[previousIndexThanLast] != 0) {
            stones[lastIndex] = stones[lastIndex] - stones[previousIndexThanLast];
            stones[previousIndexThanLast] = 0;
            Arrays.sort(stones);
        }
        return stones[lastIndex];
    }

    private void shift(int[] stones, int previousIndexThanLast) {
        for (int i = previousIndexThanLast; i >= 0; i--) {
            stones[i + 2] = stones[i];
            if (i <= 1) {
                stones[i] = 0;
            }
        }
    }

    private void add(int[] stones, int element) {
        for (int i = stones.length - 1; i >= 0; i--) {
            if (element < stones[i]) {
                continue;
            } else {

            }
        }
    }
}
