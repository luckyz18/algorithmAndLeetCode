package a2_zuo_book.capter01;

import java.util.Stack;

/**
 * 求最大子矩阵的大小
 */
public class MaxSubMatric {
    public static int getREcSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int[] height = new int[map[0].length];
        int maxArea = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxArea = Math.max(maxArea, maxRecFrombottom(height));
        }
        return maxArea;

    }

    public static int maxRecFrombottom(int[] height) {
        int maxSize = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {  // ! 相等的也弹
                Integer popINdex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int rightIndex = i;
                maxSize = Math.max((rightIndex - leftIndex - 1) * height[popINdex], maxSize);

            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            Integer popINdex = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int rightIndex = height.length;
            maxSize = Math.max((rightIndex - leftIndex - 1) * height[popINdex], maxSize);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        int rEcSize = getREcSize(new int[][]{{1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 0}});
        System.out.println(rEcSize);
    }

}
