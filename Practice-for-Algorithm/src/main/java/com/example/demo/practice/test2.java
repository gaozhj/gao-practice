package com.example.demo.practice;

import java.util.Arrays;

/**
 * @author gaozijian
 * @date 2019/8/16 9:37
 */
public class test2 {
    /**
     * 4. 二维数组中的查找
     */
    private boolean find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        // 从右上角开始
        int r = 0, c = cols - 1;
        while (r <= rows - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            } else {
                c--;
            }
        }
        return false;
    }

    public void run() {
        int[][] matrix =
                {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        //多维数组用deepToString
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(find(16, matrix));
        System.out.println(find(20, matrix));
    }
}
