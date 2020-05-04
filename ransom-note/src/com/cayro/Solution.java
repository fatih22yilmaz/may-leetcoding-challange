package com.cayro;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Integer> ransomNoteLettersMap = ransomNote.chars().boxed().collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum));

        for (int magazineLetter : magazine.toCharArray()) {
            Integer value = ransomNoteLettersMap.get(magazineLetter);
            if (value == null) {
                continue;
            }
            if (value > 1) {
                ransomNoteLettersMap.replace(magazineLetter, value - 1);
            } else {
                ransomNoteLettersMap.remove(magazineLetter);
            }
        }

        return ransomNoteLettersMap.isEmpty();
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Integer, Integer> ransomNoteLettersMap = new HashMap<>();

        for (int ransomNoteLetter : ransomNote.toCharArray()) {
            ransomNoteLettersMap.put(ransomNoteLetter, ransomNoteLettersMap.getOrDefault(ransomNoteLetter, 0) + 1);
        }

        for (int magazineLetter : magazine.toCharArray()) {
            Integer value = ransomNoteLettersMap.get(magazineLetter);
            if (value == null) {
                continue;
            }
            if (value > 1) {
                ransomNoteLettersMap.replace(magazineLetter, value - 1);
            } else {
                ransomNoteLettersMap.remove(magazineLetter);
            }
        }

        return ransomNoteLettersMap.isEmpty();
    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        int[] ransomNoteLettersArray = new int[26];

        int count = 0;

        for (int ransomNoteLetter : ransomNote.toCharArray()) {
            ransomNoteLettersArray[ransomNoteLetter - 97]++;
            count++;
        }

        for (int magazineLetter : magazine.toCharArray()) {
            if (ransomNoteLettersArray[magazineLetter - 97] > 0) {
                ransomNoteLettersArray[magazineLetter - 97]--;
                count--;
            }
        }

        return count == 0;
    }

    public boolean canConstruct4(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int caps[] = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1)
                return false;
            caps[c - 97] = index + 1;
        }
        return true;
    }

    public boolean canConstruct5(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] chars = new int[26];
        int counts = 0;
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (chars[index] == 0) counts++;
            chars[index]++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            if (chars[index] == 1) counts--;
            if (counts == 0) return true;
            chars[index]--;
        }

        return counts == 0;
    }
}
