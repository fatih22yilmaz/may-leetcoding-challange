package com.cayro;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int firstUniqChar(String s) {
        int[] lettersArray = new int[128];

        char[] chars = s.toCharArray();

        for (int c : chars) {
            lettersArray[c]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (lettersArray[chars[i]] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) { //badd solution
        Set<Integer> nonUniqueCharacters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int character = s.charAt(i);
            if (s.indexOf(character, i + 1) == -1 && !nonUniqueCharacters.contains(character)) {
                return i;
            }
            nonUniqueCharacters.add(character);
        }
        return -1;
    }

    public int firstUniqChar3(String s) {
        int res = Integer.MAX_VALUE;

        for (int i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && s.lastIndexOf(i) == index) {
                res = Math.min(res, index);
            }
        }
        return res < Integer.MAX_VALUE ? res : -1;
    }
}
