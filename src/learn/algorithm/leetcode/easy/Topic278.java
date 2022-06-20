package learn.algorithm.leetcode.easy;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/6 下午4:10
 */
public class Topic278 {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // TODO 判断是否是错误版本 if (isBadVersion(mid))
            if (true) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return right;


    }
}
