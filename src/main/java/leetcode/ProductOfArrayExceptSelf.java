package leetcode;

import java.util.Arrays;
import java.util.Objects;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] result = new int[]{4, 5, 1, 8, 2};
        System.out.println(
                Objects.equals(
                        Arrays.toString(productExceptSelf(new int[]{4, 5, 1, 8, 2})),
                        Arrays.toString(result)
                )
        );
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftToRight = new int[length];
        int[] rightToLeft = new int[length];

        leftToRight[0] = 1;
        for (int i = 1; i < length; i++) {
            leftToRight[i] = nums[i - 1] * leftToRight[i - 1];
        }

        rightToLeft[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightToLeft[i] = nums[i + 1] * rightToLeft[i + 1];
        }

        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = leftToRight[i] * rightToLeft[i];

        }
        return result;
    }
}
