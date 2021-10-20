package learn.leetcode.easy;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/4 下午3:06
 */
public class Topic35 {

    public int searchInsert(int[] nums, int target) {

        if (target > nums[nums.length-1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }

        }
        return left;

    }

    public static void main(String[] args) {
        int[] nums ={1};
        int res = new Topic35().searchInsert(nums,0);
        System.out.println(res);
    }
}
