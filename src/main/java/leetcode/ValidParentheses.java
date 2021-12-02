package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        Utils.exec(ValidParentheses::isValid,"()", true);
        Utils.exec(ValidParentheses::isValid,"()[]{}", true);
        Utils.exec(ValidParentheses::isValid,"(]", false);
        Utils.exec(ValidParentheses::isValid,"([)]", false);
        Utils.exec(ValidParentheses::isValid,"{[]}", true);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')'); break;
                case '[': stack.push(']'); break;
                case '{': stack.push('}'); break;
                default: if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}


