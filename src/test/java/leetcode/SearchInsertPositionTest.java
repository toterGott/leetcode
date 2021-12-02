package leetcode;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchInsertPositionTest {

    final SearchInsertPosition solution = new SearchInsertPosition();

    @Test
    public void test() {
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6}, 0)).isZero();
        assertThat(solution.searchInsert(new int[]{1}, 0)).isZero();
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6, 7}, 8)).isEqualTo(5);
        assertThat(solution.searchInsert(new int[]{1, 3, 5, 6, 9}, 8)).isEqualTo(4);
    }
}