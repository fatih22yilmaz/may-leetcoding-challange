package com.cayro;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public int findJudge(int N, int[][] trust) {

        if (trust.length <= 0) {
            return N;
        }

        Set<Integer> trustsSet = IntStream.range(1, N + 1).boxed().collect(Collectors.toSet());
        Map<Integer, Set<Integer>> trustedMap = new HashMap<>();

        for (int[] pair : trust) {
            trustsSet.remove(pair[0]);
            Set<Integer> trustedSet = trustedMap.get(pair[1]);

            if (Objects.isNull(trustedSet)) {
                Set<Integer> integers = new HashSet<>();
                integers.add(pair[0]);
                trustedMap.put(pair[1], integers);
            } else {
                trustedSet.add(pair[0]);
            }
        }

        Integer judge;
        if (trustsSet.size() != 1) {
            return -1;
        } else {
            judge = trustsSet.stream().findFirst().orElseThrow();

            Set<Integer> trustedVillagers = trustedMap.get(judge);
            if (Objects.isNull(trustedVillagers)) {
                return -1;
            }

            for (int i = 1; i < N; i++) {
                if (!trustedVillagers.contains(i) && i != judge) {
                    return -1;
                }
            }
        }

        return judge;
    }

    public int findJudge2(int N, int[][] trust) {

        if (trust.length <= 0) {
            return N;
        }

        Set<Integer> trustsSet = IntStream.range(1, N + 1).boxed().collect(Collectors.toSet());
        Set<Integer> trustedBySet = IntStream.range(1, N + 1).boxed().collect(Collectors.toSet());
        for (int[] i : trust) {
            trustsSet.remove(i[0]);
        }

        if (trustsSet.size() != 1) {
            return -1;
        }

        Integer judge = trustsSet.stream().findFirst().orElseThrow();

        for (int[] i : trust) {
            if (i[1] == judge) {
                trustedBySet.remove(i[0]);
            }
        }

        if (trustedBySet.size() != 1 && !trustedBySet.stream().findFirst().get().equals(judge)) {
            return -1;
        }

        return judge;
    }

    public int findJudge3(int N, int[][] trust) {
        if (trust.length < N - 1) {
            return -1;
        }

        int[] inEdges = new int[N + 1];
        int[] outEdges = new int[N + 1];
        for (int[] relation : trust) {
            outEdges[relation[0]]++;
            inEdges[relation[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (inEdges[i] == N - 1 && outEdges[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
