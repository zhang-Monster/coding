package learn.algorithm.leetcode.easy;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/21 上午11:15
 */
public class Topic441 {
    /**
     * 假设共有完整的阶梯行k
     * 所需的硬币总数为：total = ( k * (k+1) ) / 2
     * @param n 所有的硬币数
     * @return
     */
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if ( (long)mid * (mid+1) <= (long) 2 * n ) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }

        return left;

    }
}
