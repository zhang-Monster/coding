package learn.leetcode.easy;


/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/3 上午10:28
 */
public class Topic26 {

    /**
     * 双指针是一种比较常用的方法了
     * 利用双指针对数组进行去重
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return len;
        }
        int fast = 1, slow = 1;
        while (fast < len) {
            if (nums[fast] != nums[fast -1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums ={0,0,1,1,1,2,3,3,4,4,4};
        int result = new Topic26().removeDuplicates(nums);
        System.out.println(result);
    }
}
