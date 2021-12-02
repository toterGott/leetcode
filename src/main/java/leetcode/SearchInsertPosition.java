package leetcode;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        if (target > nums[right]) return right + 1;

        while (right > left + 1) {
            int middle = (left + right) / 2;

            if (nums[middle] == target) return middle;

            if (target < nums[middle]) {
                right = middle;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }
        }

        if (target > nums[left]) return right;
        return left;
    }


    public int searchInsertON(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
}
