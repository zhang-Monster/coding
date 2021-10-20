package learn.leetcode.easy;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/6 下午3:13
 */
public class Topic367 {

    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }

        int left = 1;
        int right = num / 2;
        boolean flag = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 如果用 mid * mid 进行判断 当num过大会出现越界的情况
            if (mid == (float)num / mid) {
                flag = true;
                break;
            }else if (mid < (float)num / mid) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new Topic367().isPerfectSquare(5));

    }
}
