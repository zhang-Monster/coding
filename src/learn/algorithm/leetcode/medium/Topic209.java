package learn.algorithm.leetcode.medium;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/12 下午6:35
 */
public class Topic209 {

    /**
     * 滑动窗口
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (int right = left; right < nums.length; right++) {
            sum += nums[right];


            // 找出最短的子序列
            while (sum >= target) {
                // 这里取min 因此result初始值要够大
                result = Math.min(result,right - left + 1);
                // sum 先减去nums[left] left++；
                sum -= nums[left ++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }

    public static void main(String[] args) {
        int[] nums ={2,3,1,2,4,3};
        System.out.println(new Topic209().minSubArrayLen(7,nums));
    }
}
