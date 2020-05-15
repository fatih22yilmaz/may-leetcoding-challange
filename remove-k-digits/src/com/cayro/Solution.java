package com.cayro;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public String removeKdigits(String num, int k) {
        List<Integer> numsList = new ArrayList<>(num.length());

        for (char i : num.toCharArray()) {
            numsList.add(Character.getNumericValue(i));
        }

        for (int i = 0; i < numsList.size() && k > 0; i++) {
            int numericValueI = numsList.get(i);
            int numericValueIPlusOne = 0;

            if (i + 1 < numsList.size()) {
                numericValueIPlusOne = numsList.get(i + 1);
            } else {
                numsList.remove(i);
                k--;
                break;
            }

            if (numericValueI <= numericValueIPlusOne) {
                continue;
            } else {
                numsList.remove(i);
                i = i != 0 ? i - 2 : i - 1;
                k--;
            }

        }

        while (k > 0) {
            numsList.remove(numsList.size() - 1);
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numsList.size(); i++) {
            if (i == 0 && numsList.get(i) == 0) {
                numsList.remove(i);
                i--;
            } else {
                sb.append(numsList.get(i));
            }
        }

        if (sb.length() == 0) {
            sb.append(0);
        }

        return sb.toString();
    }

    public String removeKdigits2(String num, int k) {
        Stack<Integer> numsStack = new Stack<>();

        char[] chars = num.toCharArray();
        for (int i = 0, j = 1; j < num.length(); i++, j++) {
            int firstDigit = Character.getNumericValue(chars[i]);
            int secondDigit = Character.getNumericValue(chars[j]);

            if (k <= 0 || firstDigit <= secondDigit) {
                numsStack.push(firstDigit);

            } else {
                k--;
                while (k > 0 && numsStack.size() > 0 && numsStack.peek() > secondDigit) {
                    k--;
                    numsStack.pop();
                }
            }
        }

        int lastChar = Character.getNumericValue(chars[num.length() - 1]);
        numsStack.push(lastChar);

        while (k > 0) {
            numsStack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        numsStack.forEach(sb::append);

        while (sb.indexOf("0") == 0) {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            sb.append(0);
        }

        return sb.toString();
    }
}
