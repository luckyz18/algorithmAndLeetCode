package a3_jianzhi_offer;

/**
 * 矩阵中的路径
 * 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 */

public class code_12 {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private static int rows;
    private static int cols;

    public static boolean hasPath(char[] array, int r, int c, char[] str) {
        if (r == 0 || c == 0)
            return false;
        rows = r;
        cols = c;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtracking(char[][] matrix, char[] str,  boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == str.length){
            return true;
        }
        boolean hasP = false;
        if (r >=0 && r< rows && c>=0 && c< cols
                && matrix[r][c] == str[pathLen] && !marked[r][c]){

            pathLen++;
            marked[r][c] = true;
            hasP = backtracking(matrix,str,marked,pathLen,r-1,c)
                    ||
                    backtracking(matrix,str,marked,pathLen,r,c-1)
                    ||
                    backtracking(matrix,str,marked,pathLen,r+1,c)
                    ||
                    backtracking(matrix,str,marked,pathLen,r,c+1);

            if (!hasP){
                pathLen--;
                marked[r][c] = false;
            }
        }
        return hasP;
    }

    //看不懂 。。
    private boolean backtracking2(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {

        if (pathLen == str.length)
            return true;
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c]) {

            return false;
        }
        marked[r][c] = true;
        for (int[] n : next)
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        marked[r][c] = false;
        return false;
    }


    private static char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
        return matrix;
    }

    public static void main(String[] args) {
        char[] array = "abtgcfcsjdeh".toCharArray();
        int rows = 3;
        int col = 4;
        char[] str = "bfct".toCharArray();
        boolean b = hasPath(array, rows, col, str);
        System.out.println(b);
    }
}
