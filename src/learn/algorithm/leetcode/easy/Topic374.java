package learn.algorithm.leetcode.easy;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/21 上午10:48
 */
public class Topic374 {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // 选出的数字比猜测的数字小 区间缩小为[left,mid]
            if (guess(mid) <= 0) {
                right = mid;

            }else {
                // 选出的数字比猜测的数字大 区间缩小为[mid+1,right]
                left = mid + 1;
            }
        }
        // left == right, 区间缩小为一个点,即为答案
        return left;
    }

    public int guess(int num) {

        int result = 0;

        //TODO 预先定义好的接口获取猜测结果

        return result;
    }
}
