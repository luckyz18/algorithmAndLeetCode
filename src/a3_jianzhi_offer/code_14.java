package a3_jianzhi_offer;

/**
 * 剪绳子
 */
public class code_14 {
    //动态规划
    public static int integerBreak(int n) {
        if (n<=1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    //
    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    //贪婪
    public static int integerBreak3(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1)
            timesOf3--;
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
    }

    public static void main(String[] args) {
        int i = integerBreak3(5);
        System.out.println(i);
    }

}
