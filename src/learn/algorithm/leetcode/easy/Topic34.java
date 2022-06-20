package learn.algorithm.leetcode.easy;


/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/4 下午4:45
 */
public class Topic34 {
    public int[] searchRange(int[] nums, int target) {
        // target =  target - 1 ，第一个大于target的下标即为起始下标 这思路可以的
        int start = binarySearch(nums,target - 1);
        int end = binarySearch(nums,target) - 1;
        if (start <= end && nums[start] == target) {
            return new int[]{start,end};
        }


        return new int[]{-1,-1};
    }

    /**
     * 利用二分法查找第一个大于target的下标
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums,int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                index = mid;
            }else {
                left = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums ={1};
        int[] res = new Topic34().searchRange(nums,1);
        for (int x : res) {
            System.out.println(x);
        }

    }
}
