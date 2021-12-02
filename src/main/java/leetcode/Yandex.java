package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Yandex {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1}, {3,1}, {0,2}, {4, 2}};
        System.out.println(isMirrored(points));
        points = new int[][]{{1,1}, {3,2}};
        System.out.println(isMirrored(points));

//        A4B3C2XYZD4E3F3A6B28
//        A4B3C2XYZD4E3F3A6B28
//        System.out.println(rle("AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"));
//        System.out.println(rle("AA"));
    }

    public static boolean isMirrored(int[][] points) {
        // Про входные данные ничего не сказано, поэтому для стенок берем крайние значения стенок
        // для поиска ширины фигуры
        int rightBorder = Integer.MAX_VALUE;
        int leftBorder = Integer.MIN_VALUE;

        // Группируем точки по Х
        HashMap<Integer, HashSet<Integer>> groupedByXPoints = new HashMap();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            rightBorder = Math.min(rightBorder, x);
            leftBorder = Math.max(leftBorder, x);

            if (!groupedByXPoints.containsKey(x)) {
                groupedByXPoints.put(x, new HashSet());
            }

            groupedByXPoints.get(x).add(y);
        }

        // "Ширина" фигуры
        int bordersSum = rightBorder + leftBorder;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            // Вычитая текущую Х из суммы мы должны попадать на противоложную сторону фигуры для этой точки
            int centerX = bordersSum - x;

            // Теперь нужно сделать проверить, что такая точка есть с другой стороны
            if (!groupedByXPoints.containsKey(centerX) || !groupedByXPoints.get(centerX).contains(y)) {
                return false;
            }
        }

        return true;
    }

    private static int findMaxX(int[][] points) {
        int max = 0;
        for (int[] p : points) {
            if (p[0] > max) max = p[0];
        }
        return max;
    }

    public static String rle(String str) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        char prev = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == prev) {
                count++;
            } else {
                result.append(str.charAt(i - 1));
                if (count != 0) result.append(count + 1);
                count = 0;
                prev = c;
            }
        }

        result.append(str.charAt(str.length() - 1));
        if (count != 0) result.append(count + 1);

        return result.toString();
    }
}
