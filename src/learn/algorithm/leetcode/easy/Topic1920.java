package learn.algorithm.leetcode.easy;


/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/2 下午6:25
 */
public class Topic1920 {

    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums ={0,2,1,5,3,4};
        int[] res = new Topic1920().buildArray(nums);
        for (int re : res) {
            System.out.println(re);
        }

    }
}
