package com.leetpractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] inputArray = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(inputArray, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[1] = i;
                result[0] = map.get(diff);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
