package learn.leetcode.easy;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/5 下午4:16
 */
public class Topic69 {

    /**
     * ？？？？？？？？？？？？？？？？？？？
     * @param x
     * @return
     */
    public int mySqrt(int x) {

//        return (int)Math.sqrt(x);
        return (int)Math.pow(x,0.5);

    }

    /**
     * 二分查找求平方根
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        int left = 0;
        int right = x ;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - 1) / 2;
            System.out.println(mid);
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Topic69().mySqrt2(8));
    }
}
