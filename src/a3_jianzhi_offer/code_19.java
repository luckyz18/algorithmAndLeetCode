package a3_jianzhi_offer;

/**
 * 正则表达式匹配
 */
public class code_19 {

    //网上
    public static boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }
    //
    public static boolean match2(char[] str, char[] pattern)
    {
        return new String(str).matches(new String(pattern));
    }


    /**
     * 比较好理解
     * @param str
     * @param pattern
     * @return
     */
    public static boolean match3(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
            return false;
        }
        return match3(str, 0, pattern, 0);
    }
    private static boolean match3(char[] str, int i, char[] pattern, int j){
        //特别注意这里：一定是判断pattern是否遍历完了 //都到结尾了
        if(pattern.length == j){
            return str.length == i;
        }
        //如果遇到*就是很特殊的情况了
        if(j < pattern.length - 1 && pattern[j+1] == '*'){
            if(i < str.length && (str[i] == pattern[j] || pattern[j] == '.')){
                //匹配上了，有两条路可以往后走！！这其实就是dfs暴力搜索啊
                return match3(str, i, pattern, j+2)
                        ||
                        match3(str, i+1, pattern, j)
                        ||
                        match3(str,i+1,pattern,j+2);

            }else{
                //没匹配上，那个*就代表其前面的字母使用0次
                return match3(str, i, pattern, j+2);
            }
        }

        //没遇到*就是最简单的了。
        if(i < str.length && (str[i] == pattern[j] || pattern[j] == '.')){
            return match3(str, i+1, pattern, j+1);
        }
        return false;
    }

    //
    public static boolean match4(char[] str, char[] pattern)
    {
        if(str == null || pattern == null){
        return false;
    }
        return match4(str,0,pattern,0);
    }
    public static boolean match4(char[] str, int i, char[] pattern, int j){
        if(j == pattern.length ){
            return i== str.length;
        }
        if(j<pattern.length-1 && pattern[j+1] == '*'){
            if(i< str.length && (str[i] == pattern[j] || pattern[j] == '.')){
                return match4(str, i, pattern, j+2)
                        ||
                        match4(str, i+1, pattern, j)
                        ||
                        match4(str,i+1,pattern,j+2);
            }
            else{
                return match4(str,i,pattern,j+2);
            }
        }

        if( i< str.length && (str[i] == pattern[j] || pattern[j] == '.')){
            return match4(str,i+1,pattern,j+1);
        }

        return false;
    }

    public static void main(String[] args) {
        boolean m = match4("".toCharArray(), "a*".toCharArray());
        System.out.println(m);

    }
}
