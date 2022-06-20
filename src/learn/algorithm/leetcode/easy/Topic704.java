package learn.algorithm.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/3 下午6:05
 */
public class Topic704 {

    /**
     * 二分法
     * 区间左闭右闭 [left，right]
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        // 避免多次进行循环
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return  -1;
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

        return -1;
    }

    /**
     * map映射解决
     * 但是得保证数组中的元素没有重复
     * @param nums
     * @param target
     * @return
     */
    public int search2(int[] nums, int target) {
        int index = -1;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i++ ){
            map.put(nums[i],i);
        }

        if (map.containsKey(target)) {
            index = map.get(target);
        }

        return index;

    }

    public static void main(String[] args) {
        int[] nums ={1,2,3,4,5,7,9};
        int res = new Topic704().search(nums,6);
        System.out.println(res);
    }
}
