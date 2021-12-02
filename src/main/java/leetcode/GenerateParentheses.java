package com.leetpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Utils.exec(GenerateParentheses::generateParenthesis,
                1,
                Arrays.asList("()"));
        Utils.exec(GenerateParentheses::generateParenthesis,
                3,
                Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrace(result, "", 0, 0, n);
        return result;
    }

    private static void backtrace(List<String> result, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (open < max) backtrace(result, str + "(", open + 1, close, max);
        if (close < open) backtrace(result, str + ")", open, close + 1, max);
    }
}
