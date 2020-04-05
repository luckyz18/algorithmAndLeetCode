package jianzhi_offer;

/**
 * 斐波那契数列
 */
public class code_10 {
    //时间复杂度O(N) 空间O(N)
    public int Fibonacci(int n) {
        if (n <=1){
            return n;
        }
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <=n ; i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    //时间复杂度O(N) 空间O(1)
    public int Fibonacci2(int n) {
        if (n <= 1){
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int res = 0;
        for (int i = 2; i <=n ; i++) {
            res = pre2 + pre1;
            pre2 = pre1;
            pre1 = res;
        }
        return res;
    }

}
