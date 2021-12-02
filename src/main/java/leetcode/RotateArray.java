package leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int maxIdx = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            int newIndex = i + k;
            if (newIndex > maxIdx) newIndex -= maxIdx;

            int acc = nums[newIndex];
            nums[newIndex] = nums[i];
            nums[i] = acc;
        }
    }
}
