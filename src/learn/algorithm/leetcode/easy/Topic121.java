package learn.algorithm.leetcode.easy;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/18 上午10:47
 */
public class Topic121 {

    /**
     * 暴力破解法
     * 找出给定数组中两个数字之间的最大差值（最大利润）
     * 此外，第二个数字必须大于第一个数字
     * max(prices[j] - prices[i])
     *
     * 超出时间限制。。。。。
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }

        return maxProfit;

    }


    /**
     *
     * 动态规划
     * 第i天的最大收益只需要知道前i天的最低点就可以算出来了，而第i天以前(包括第i天)的最低点和i-1天的最低点有关
     * 至此列出动态方程
     * dp[i] = min(d[i-1],prices[i])
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;

        int[] dp = new int[prices.length];
        // dp[i] 表示截止到i，价格的最低点是多少
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i - 1], prices[i]);
            maxProfit = Math.max(prices[i] - dp[i], maxProfit);
        }


        return maxProfit;
    }

    /**
     * 动态规划优化空间复杂度
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;

            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(maxProfit3(prices));
    }
}
