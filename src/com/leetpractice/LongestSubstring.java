package com.leetpractice;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {

    public static void main(String[] args) {
        System.out.println(countLongestSubstring("ababcabcde"));
        System.out.println(countLongestSubstring("ababc"));
        System.out.println(countLongestSubstring("abbca"));
        System.out.println(countLongestSubstring("abbca"));
    }

    private static Integer countLongestSubstring(String input) {
        Map<Character, Integer> charMap = new HashMap();
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < input.length(); i++) {
            if (charMap.containsKey(input.charAt(i))) {
                maxLength = Math.max(charMap.size(), maxLength);
                maxLength = Math.max(i - start, maxLength);
                int foundId = charMap.get(input.charAt(i));
                while (start <= foundId) {
                    charMap.remove(input.charAt(start++));
                }
            }
            charMap.put(input.charAt(i), i);
        }

        return Math.max(charMap.size(), maxLength);
    }
}
