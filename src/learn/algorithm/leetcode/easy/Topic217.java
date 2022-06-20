package learn.algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/11 下午3:15
 */
public class Topic217 {

    /**
     * 利用set进行判断
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }else {
                set.add(num);
            }
        }

        return false;

    }

    /**
     * 利用stream流去重处理
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums){

        int len = nums.length;
        long count = Arrays.stream(nums).distinct().count();

        return len != count;
    }

    /**
     * 对数组进行排序
     * 判断排序后的数组是否有相邻的两个元素相同
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        HashSet<int[]> set1 = new HashSet<>(Arrays.asList(nums));

        HashSet set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {

            }else {
                set.add(num);
            }
        }

        // 这个地方注意 hashSet底层也是hashMap 直接放入数组 为一个下标
        System.out.println("set1的长度为:" + set1.size() + "\nset的长度为:" + set.size());

        // 直接对原数组进行排序
        Arrays.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }


//        System.out.println(new Topic217().containsDuplicate(nums));
    }


}
