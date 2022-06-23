package learn.algorithm.leetcode.easy;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/9 下午3:32
 */
public class Topic283 {

    public void moveZeroes(int[] nums) {

        /**
         * 单次遍历
         * 跟双次遍历的优化差不多
         */
        for (int i = 0,count = 0; i < nums.length; i++){
            if (nums[i] != 0) {
                // 优化一下
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count ++;
            }
        }

    }

    /**
     * 两次遍历
     * 第一次遍历所有非0元素并进行移动
     * 第二次对剩余的部分进行补0
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        if(nums == null) {
            return;
        }

        // 遍历数组 所有非0的移动到最左端
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
            
        }
        // 非0的元素处理完了 剩下的都为0 对数组进行补0操作
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public void moveZeroes3(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;

        // 这种写法比第一种可读性高一点
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[j] = nums[i];
                nums[j++] = tmp;
            }

        }

    }





    public static void main(String[] args) {
        int[] nums ={0,1,0,3,12};
        new Topic283().moveZeroes(nums);

        for (int x : nums) {
            System.out.println(x);
        }
    }
}
