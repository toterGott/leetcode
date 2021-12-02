package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneNumbersLetters {
    public static void main(String[] args) {
        Utils.exec(PhoneNumbersLetters::letterCombinations,
                "23",
                Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    }

    final static String[] keyMapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        traceback("", result, 0, digits);
        return result;
    }

    private static void traceback(String str, List<String> result, int offset, String digits) {
        if (offset == digits.length()) {
            result.add(str);
            return;
        }

        String letters = keyMapping[digits.charAt(offset) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            traceback(str + letters.charAt(i), result, offset + 1, digits);
        }
    }
}
