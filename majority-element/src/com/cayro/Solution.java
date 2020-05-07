package com.cayro;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length, 1.0F);
        for (int i : nums) {
            Integer value = map.getOrDefault(i, 0);
            int newValue = value + 1;
            map.put(i, newValue);
            if (newValue >= Math.ceil(length / 2.0)) {
                return i;
            }
        }

        return 0;
    }

    public int majorityElement2(int[] nums) {
        int leader = nums[0], leader_count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == leader) leader_count++;
            else {
                leader_count--;
                if (leader_count == 0) {
                    if (i < nums.length - 1) {
                        leader = nums[i + 1];
                        leader_count = 1;
                        i++;
                    }
                }
            }
        }
        return leader;
    }

    public int majorityElement3(int[] nums) {
        int majorityElement = nums[0], count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majorityElement) {
                count++;
            } else {
                if (--count == 0) {
                    majorityElement = nums[i];
                    count = 1;
                }

            }
        }

        return majorityElement;
    }

}
