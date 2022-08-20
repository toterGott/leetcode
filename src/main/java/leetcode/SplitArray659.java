package leetcode;

import java.util.ArrayList;

public class SplitArray659 {

    class Pair implements Comparable<Pair> {

        Integer length;
        Integer lastNum;

        public Pair(Integer length, Integer lastNum) {
            this.length = length;
            this.lastNum = lastNum;
        }

        @Override
        public int compareTo(Pair o) {
            return o.length.compareTo(length);
        }
    }

    public boolean isPossible(int[] nums) {
        ArrayList<Pair> subs = new ArrayList<>();
        for (int number : nums) {
            boolean notFound = true;
            for (Pair sub : subs) {
                if (sub.lastNum + 1 == number) {
                    sub.lastNum = number;
                    sub.length += 1;
                    notFound = false;
                    break;
                }
            }
            if (notFound) subs.add(0, new Pair(1, number));
        }

        return subs.stream().noneMatch(it -> it.length < 3);
    }
}
