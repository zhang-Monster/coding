package learn.algorithm.leetcode.easy;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/9 下午3:32
 */
public class Topic283 {

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0,count = 0; i < nums.length; i++){
            if (nums[i] != 0) {
//                nums[index] = nums[i];
//                index ++;

                // 优化一下
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count ++;
            }
        }

//        for (int j = index; j < nums.length; j++){
//            nums[j] = 0;
//        }
    }

    public static void main(String[] args) {
        int[] nums ={0,1,0,3,12};
        new Topic283().moveZeroes(nums);

        for (int x : nums) {
            System.out.println(x);
        }
    }
}
