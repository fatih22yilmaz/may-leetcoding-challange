package com.cayro;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public int numJewelsInStones(String J, String S) {

        Map<Character, Integer> collect = S.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        return J.chars().mapToObj(c -> (char) c).map(collect::get).filter(Objects::nonNull).mapToInt(Integer::valueOf).sum();
    }

    public int numJewelsInStones2(String J, String S) {

        Map<Integer, Integer> collect = S.chars().boxed().collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        return J.chars().boxed().map(collect::get).filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
    }

    public int numJewelsInStones3(String J, String S) {

        int[] charCounts = new int[128];

        for (char c : S.toCharArray()) {
            charCounts[c]++;
        }

        int count = 0;

        for (char j : J.toCharArray()) {
            count += charCounts[J.codePointAt(j)];
        }
        return count;
    }

    public int numJewelsInStones4(String J, String S) {
        Set<Character> jewels = new HashSet<>();

        for (int i = 0; i < J.length(); i++) {
            jewels.add(J.charAt(i));
        }

        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (jewels.contains(S.charAt(i))) {
                ans++;
            }
        }

        return ans;
    }
}
