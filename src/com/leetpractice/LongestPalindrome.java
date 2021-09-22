package com.leetpractice;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        exec("babad", "bab");
        exec("aba", "aba");
        exec("bb", "bb");
        exec("a", "a");
        exec("ac", "a");
        exec("ccc", "ccc");
        exec("aaaa", "aaaa");
        exec("aacabdkacaa", "aca");
        exec("cbbd", "bb");
        if (isAnyError) {
            System.out.println("\n######## NOT PASSED :( ########");
        } else {
            System.out.println("\nEVERYTHING IS OK :)");
        }
    }

    static boolean isAnyError = false;

    public static void exec(String input, String expected) {
        String actual = longestPalindrome(input);
        if (actual.equals(expected)) {
            System.out.println("OK: " + expected + " == " + actual);
        } else {
            isAnyError = true;
            System.out.println("ERROR: " + expected + " != " + actual);
        }
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int start = 0;
        int end = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char letter = s.charAt(i);
            int tempStart = i;
            int tempEnd = i;

            // Expend to the left and to the right for same symbols one by one
            while (tempStart >= 0 && s.charAt(tempStart) == letter) {
                --tempStart; // this index moves by default, so we need to increase it at the en
            }
            while (tempEnd < length && s.charAt(tempEnd) == letter) {
                // this index also moves by default, but we shouldn't move it because substring() is inclusive
                // for second parameter
                ++tempEnd;
            }

            while (tempStart >= 0 && tempEnd < length) {
                if (s.charAt(tempStart) != s.charAt(tempEnd)) {
                    break;
                }
                --tempStart;
                ++tempEnd;
            }

            if (end - start < tempEnd - tempStart) {
                end = tempEnd;
                start = tempStart;
            }
        }

        return s.substring(start + 1, end);
    }
}
