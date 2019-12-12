package jianzhi_offer;

/**
 * 礼物的最大值
 */
public class code_47 {
    //暴力递归
    public  static int getMost(int[][] values) {
        if (values == null || values.length ==0 || values[0].length ==0 ){
            return 0;
        }
        int rows = values.length-1;
        int columns = values[0].length-1;
        return process(values,rows,columns,0,0);
    }

    private static int process(int[][] values, int rows, int columns, int m, int n) {
        if (m == rows && n == columns){
           return values[m][n];
        }else{
            if (m == rows){
                return (values[m][n] + process(values,rows,columns,m,n+1));
            }
            if (n == columns){
                return (values[m][n] + process(values,rows,columns,m+1,n));
            }
            return values[m][n] + Math.max(process(values,rows,columns,m+1,n),process(values,rows,columns,m,n+1));
        }
    }

    //从暴力递归改成动态规划
    //可变参数有两个 dp[][] 表示 i,j 位置到 右下角的最远和
    public  static int getMost2(int[][] values) {
        if (values == null || values.length ==0 || values[0].length ==0 ){
            return 0;
        }
        int rows = values.length;
        int columns = values[0].length;

        int[][] dp = new int[rows][columns];
        dp[rows-1][columns-1] = values[rows-1][columns-1];
        for (int i = columns-2; i >=0 ; i--) {
            dp[rows-1][i] = values[rows-1][i] + dp[rows-1][i+1];
        }
        for (int i = rows-2; i >=0 ; i--) {
            dp[i][columns-1] = values[i][columns-1] + dp[i+1][columns-1];
        }
        for (int i = rows-2; i >=0 ; i--) {
            for (int j = columns-2; j >=0 ; j--) {
                dp[i][j] = values[i][j] + Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int most = getMost2(new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}});
        System.out.println(most);
    }
}
