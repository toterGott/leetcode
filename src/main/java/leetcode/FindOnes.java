package leetcode;

public class FindOnes {
    public static void main(String[] args) {
//        System.out.println(findOnes(212));
//        System.out.println(findOnes(111));
//        System.out.println(findOnesBinary(5));
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(1024));
        System.out.println(isPowerOfTwo(1025));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(-2147483648));


        System.out.println(Integer.MIN_VALUE);
    }

    private static boolean isPowerOfTwo(int i) {
        if (i == Integer.MIN_VALUE) return false;
        return Integer.bitCount(i) == 1;
    }


    static public int findOnes(int num) {
        int count = 0;
        while (num % 10 != 0) {
            if (num % 10 == 1) count++;
            num = num / 10;
        }
        return count;
    }
}
