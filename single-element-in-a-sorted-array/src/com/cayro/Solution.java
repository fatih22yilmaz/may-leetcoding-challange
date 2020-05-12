package com.cayro;

public class Solution {

    public int singleNonDuplicate(int[] nums) {

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum ^= nums[i];
        }

        return sum;
    }

    public int singleNonDuplicate2(int[] nums) {

        int elem1;
        int elem2;

        for (int i = 0; i < nums.length; i += 2) {
            elem1 = nums[i];
            if (i + 1 < nums.length) {
                elem2 = nums[i + 1];
                if (elem1 != elem2) {
                    return nums[i];
                }
            } else {
                return nums[i];
            }
        }

        return -1;
    }

    public int singleNonDuplicate3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle = left + ((right - left) / 2);

        while (left <= right) {
            if (middle % 2 == 1) {
                if (middle - 1 >= 0 && nums[middle] == nums[middle - 1]) {
                    left = middle + 1;
                } else if (middle + 1 < nums.length && nums[middle] == nums[middle + 1]) {
                    right = middle - 1;
                } else {
                    return nums[middle];
                }
            } else {
                if (middle - 1 >= 0 && nums[middle] == nums[middle - 1]) {
                    right = middle - 1;
                } else if (middle + 1 < nums.length && nums[middle] == nums[middle + 1]) {
                    left = middle + 1;
                } else {
                    return nums[middle];
                }
            }
            middle = (right - left) != 2 ? left + ((right - left) / 2) : left;
        }
        return -1;
    }

    public int singleNonDuplicate4(int[] nums) {
        int lo = 0, len = nums.length, hi = len / 2;

        while (lo < hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[2 * mid] == nums[2 * mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[2 * lo];
    }
}
