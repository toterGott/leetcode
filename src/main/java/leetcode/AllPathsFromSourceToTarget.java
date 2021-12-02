package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
//        res.add(Arrays.asList(0, 1, 3));
//        res.add(Arrays.asList(0, 2, 3));
        res.add(Arrays.asList(0, 4));
        res.add(Arrays.asList(0,3,4));
        res.add(Arrays.asList(0,1,3,4));
        res.add(Arrays.asList(0,1,4));
        System.out.println(
                Objects.equals(
                        (allPathsSourceTarget(new int[][]{{4,3,1}, {3,2,4}, {}, {4}, {}})),
                        res
                )
        );
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(graph, 0, result, new ArrayList<>());
        return result;
    }

    public static void recursive(int[][] graph,
                                 int index,
                                 List<List<Integer>> result,
                                 List<Integer> path) {
        ArrayList<Integer> newPath = new ArrayList<>(path);
        newPath.add(index);

        if (index == graph.length - 1) {
            result.add(newPath);
            return;
        }

        for (int i = 0; i < graph[index].length; i++) {
            recursive(graph, graph[index][i], result, newPath);
        }
    }
}
