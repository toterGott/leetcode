package leetcode;

public class HouseRobber {
    public static void main(String[] args) {
//        System.out.println(rob(new int[]{2, 7, 9, 3, 1}) == 12);
        System.out.println(rob(new int[]{1, 2, 3, 1}) == 4);
//        System.out.println(rob(new int[]{1, 2}) == 2);
    }

    public static int rob(int[] nums) {
        int robbedPrev = 0;
        int notRobbedPrev = 0;
        for (int value : nums) {
            int currRob = notRobbedPrev + value;
            int currNotRob = Math.max(robbedPrev, notRobbedPrev);

            robbedPrev = currRob;
            notRobbedPrev = currNotRob;
        }

        return Math.max(robbedPrev, notRobbedPrev);
    }
}
