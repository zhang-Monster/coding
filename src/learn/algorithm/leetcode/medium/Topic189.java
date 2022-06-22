package learn.algorithm.leetcode.medium;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/22 上午10:29
 */
public class Topic189 {


    /**
     * 使用额外的数组将每个元素放至正确的位置
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        int len = nums.length;
        int[] arr = new int[len];

        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % len] = nums[i];
        }

        System.arraycopy(arr,0,nums,0,len);

    }


    /**
     * 数组翻转
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k - 1);

        reverse(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums,int start,int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }

    }


    public static void main(String[] args) {

        int nums[] = {1,2,3,4,5,6,7};

        rotate(nums,3);

        for (int num : nums) {
            System.out.println(num);
        }


    }
}
