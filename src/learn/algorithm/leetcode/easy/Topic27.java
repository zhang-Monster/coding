package learn.algorithm.leetcode.easy;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/9 上午10:44
 */
public class Topic27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index ++;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int[] nums ={0,1,2,2,3,0,4,2};
        int result = new Topic27().removeElement(nums,2);

        System.out.println(result);
    }
}
