package com.leetpractice;

import static com.leetpractice.Utils.exec;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        exec(ContainerWithMostWater::mostWater, new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49);
        exec(ContainerWithMostWater::mostWater, new int[]{1, 1}, 1);
        exec(ContainerWithMostWater::mostWater, new int[]{4, 3, 2, 1, 4}, 16);
        exec(ContainerWithMostWater::mostWater, new int[]{1, 2, 1}, 2);
    }

    public static int mostWater(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int wallDiff = right - left;
            int smallestWall = Math.min(height[left], height[right]);
            int water = wallDiff * smallestWall;
            if (water > maxWater) maxWater = water;
            if (height[left] < height[right]) left++;
            else right--;
        }

        return maxWater;
    }

    public static int mostWaterOld(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (i == j) continue;
                int smallestWall = Math.min(height[i], height[j]);
                int idxDiff = Math.abs(i - j);
                int water = smallestWall * idxDiff;
                if (water > max) {
                    max = water;
                }
            }
        }
        return max;
    }
}
