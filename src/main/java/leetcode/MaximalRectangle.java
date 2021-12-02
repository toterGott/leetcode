package leetcode;

import java.util.Arrays;

public class MaximalRectangle {

    public static void main(String[] args) {
        System.out.println(maximalRectangle(
                new char[][]
                        {{'1', '0', '1', '0', '0'},
                                {'1', '0', '1', '1', '1'},
                                {'1', '1', '1', '1', '1'},
                                {'1', '0', '0', '1', '0'}}
        ));
    }

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] histogram = new int[matrix[0].length];
        int maxArea = 0;

        for (int i = 0; i < matrix.length; i++) {
            char[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == '1') histogram[j]++;
                else histogram[j] = 0;
            }
            int currentMaxArea = findMaxArea(histogram);
            maxArea = Math.max(maxArea, currentMaxArea);
        }
        return maxArea;
    }

    private static int findMaxArea(int[] histogram) {
        int currMax = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] == 0) continue;
            int height = histogram[i];
            int width = 1;
            for (int j = i; j < histogram.length; j++) {
                if (histogram[j] == 0) break;
                height = Math.min(height, histogram[j]);
                if (j > i) width++;
                currMax = Math.max(currMax, height * width);
            }
        }
        return currMax;
    }
}
