package jianzhi_offer;

/**
 * 机器人的运动路径
 */
public class code_13 {
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rows][cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
        return count;
    }

    public static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if ( check(threshold, rows, cols, row, col, visited)) {

            visited[row][col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    +
                    movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    +
                    movingCountCore(threshold, rows, cols, row + 1, col, visited)
                    +
                    movingCountCore(threshold, rows, cols, row, col + 1, visited);
        }
        return count;
    }

    public static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && (getDigitSum(row) + getDigitSum(col)) <= threshold
                && !visited[row][col]) {

            return true;
        }
        return false;
    }

    public static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = new code_13().movingCount2(2, 3, 4);
        System.out.println(i);
    }

    /********************************************/
    //2.
    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;

    public  int movingCount2(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initDigitSum();
        boolean[][] marked = new boolean[rows][cols];
        dfs(marked, 0, 0);
        return cnt;
    }

    private void dfs(boolean[][] marked, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        marked[r][c] = true;
        if (this.digitSum[r][c] > this.threshold) {
            return;
        }
        cnt++;
        for (int[] n : next){
            dfs(marked, r + n[0], c + n[1]);
        }
    }

    private void initDigitSum() {
        int[] digitSumOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitSumOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitSumOne[i] += n % 10;
                n /= 10;
            }
        }
        this.digitSum = new int[rows][cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];

            }
        }
    }

}
