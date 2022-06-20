package learn.algorithm.leetcode.easy;


import java.util.Arrays;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/12 下午4:18
 */
public class Topic977 {

    /**
     * 组装新数组后排序
     * 这种方式时间复杂度有点高
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int [] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }

        // 对res进行排序
        Arrays.sort(res);

        return res;
    }

    /**
     * 双指针解法：数组是有序排序的 因此平方后最大值必然在旧数组的两头
     * @param nums
     * @return
     */
    public int[] sortedSquares2(int[] nums) {
        int [] res = new int[nums.length];
        int left = 0 , right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                // 处理完之后在进行
                res[index --] = nums[right] * nums[right --];
            }else {
                res[index --] = nums[left] * nums[left ++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums ={-4,-1,0,3,10};
        int [] res = new Topic977().sortedSquares(nums);
        for (int x : res) {
            System.out.println(x);
        }
    }
}
