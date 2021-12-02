package leetcode;

import java.util.function.Function;

public class Utils {
    public static <T,R> void exec(Function<T, R> fun,T input, R expected) {
        R actual = fun.apply(input);
        if (actual.equals(expected)) {
            System.out.println("OK: " + expected + " == " + actual);
        } else {
            System.out.println("ERROR: " + expected + " != " + actual);
        }
    }
}
