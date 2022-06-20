package learn.algorithm.leetcode.easy;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/13 下午4:49
 */
public class Topic53 {

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        // 假定数组第一个为最大，后续进行计算覆盖
        int max = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > nums[i]) {
                sum += nums[i];
            }else {
                // 归零重新计算
                sum = nums[i];
            }

            max = Math.max(max, sum);
        }

        return max;


    }

    /**
     * 动态规划代码优化
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num,num);
            maxAns = Math.max(maxAns,pre);
        }

        return maxAns;

    }

    public static void main(String[] args) {
        int nums[] = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArray(nums));


    }
}
