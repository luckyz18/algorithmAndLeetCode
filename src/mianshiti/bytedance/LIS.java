package mianshiti.bytedance;

/**
 * 在二维数组中找最长上升序列
 * 【 1 5 8
 *   2 6 7
 *   4 1 3 】   最长 1 2 6 7 8
 */
public class LIS {


    static boolean[][] flag = new boolean[3][3];
    public static int findMax(int[][] matrix,int[][] res, int m, int n){
        int left = 0, right = 0, up = 0, down = 0;
        if (m > 0 && matrix[m][n] < matrix[m - 1][n]) {
            if (!flag[m - 1][n]) {
                up = findMax(matrix, res, m - 1, n);
                res[m - 1][n] = up;
                flag[m - 1][n] = true;
            } else {
                up = res[m - 1][n];
            }
        }
        if (m+1 < matrix.length && matrix[m+1][n] > matrix[m][n]){
            if (!flag[m + 1][n]) {
                down = findMax(matrix, res, m + 1, n);
                res[m + 1][n] = down;
                flag[m + 1][n] = true;
            } else {
                down = res[m + 1][n];
            }
        }
        if (n > 0 && matrix[m][n] < matrix[m][n-1]){
            if (!flag[m][n - 1]) {
                left = findMax(matrix, res, m, n - 1);
                res[m][n - 1] = left;
                flag[m][n - 1] = true;
            } else {
                left = res[m][ n - 1];
            }
        }
        if (n+1 < matrix[0].length && matrix[m][n] < matrix[m][n+1]){
            if (!flag[m][n + 1]) {
                right = findMax(matrix, res, m, n + 1);
                res[m][n + 1] = right;
                flag[m][n + 1] = true;
            } else {
                right = res[m][ n + 1];
            }
        }
        res[m][n] = Math.max(Math.max(Math.max(down,up),left),right) +1 ;
        int path = findMAxValue(res);
        return path;
    }

    private static int findMAxValue(int[][] res) {
        if (res == null || res.length == 0 || res[0].length == 0){
            return 0;
        }
        int m = res.length;
        int n = res[0].length;
        int maxPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j=0; j< n; j++){
                maxPath = Math.max(maxPath,res[i][j]);
            }
        }
        return maxPath;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,5,8},{2,6,7},{4,1,3}};

        int[][] res = new int[3][3];
        int max = findMax(matrix, res, 0, 0);
        System.out.println(max);
    }
}
