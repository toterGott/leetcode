package leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SplitArray659Test {

    final SplitArray659 solution = new SplitArray659();

    @Test
    void test() {
        Function<int[], Boolean> func = solution::isPossible;
        assertThat(func.apply(new int[]{1, 2, 3, 3, 4, 5})).isTrue();
        assertThat(func.apply(new int[]{1, 2, 3, 3, 4, 4, 5, 5})).isTrue();
        assertThat(func.apply(new int[]{1, 2, 3, 4, 4, 5})).isFalse();
        assertThat(func.apply(new int[]{1, 2, 3, 5, 5, 6, 7})).isFalse();
    }
}
