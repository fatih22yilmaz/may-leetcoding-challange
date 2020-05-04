package com.cayro;

public class Solution {

    public int findComplement(int num) {

        String binaryString = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        for (char digit : binaryString.toCharArray()) {
            if (digit == '1') {
                sb.append("0");
            } else {
                sb.append('1');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int findComplement2(int num) {

        int exponent = 32 - Integer.numberOfLeadingZeros(num);

        int upperLimit = ((int) Math.pow(2, exponent));
        if (exponent != 31) {
            upperLimit--;
        }
        return upperLimit - num;
    }

    public int findComplement3(int num) {

        int cp = num;
        int sum = 0;
        while (num > 0) {
            sum = (sum << 1) + 1;
            num >>= 1;
        }
        return sum - cp;
    }
}
