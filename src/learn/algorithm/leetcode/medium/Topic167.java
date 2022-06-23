package learn.algorithm.leetcode.medium;



/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/23 上午10:48
 */
public class Topic167 {

    /**
     * 本来想用hashmap的 但是数组中的元素是有重复的 遂放弃
     *
     * 二分查找的方式 先固定一个数 在寻找另外一个数
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int low = i + 1;
            int high = numbers.length - 1;

            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1,mid + 1};
                }else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;

                }else {
                    low = mid + 1;
                }
            }

        }

        return new int[]{-1,-1};

    }

    /**
     * 双指针解法
     * 分别从数组的两端开始遍历
     * 两个数字的和大于目标值 右边的指针左移
     *           小于目标值 左边的指针右移
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {

        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1,high + 1};
            }else if (sum < target) {
                low ++;
            }else {
                high --;
            }
        }

        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] numbers = {0,0,3,4};
        int[] ints = twoSum(numbers, 0);

        for (int i : ints) {
            System.out.println(i);
        }
    }
}
