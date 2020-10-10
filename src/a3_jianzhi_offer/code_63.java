package a3_jianzhi_offer;

/**
 * 股票的最大利润
 */
public class code_63 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7,6,4,3,1});
        System.out.println(i);
    }
}
