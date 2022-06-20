package learn.algorithm.leetcode.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/3/14 下午8:07
 */
public class Topic1 {
    static int a = 1;

    public int[] twoSum(int[] nums, int target) {


        //建立k-v,一一对应的哈希表
        Map<Integer,Integer> exitsMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (exitsMap.containsKey(target - nums[i])){
                return new int[]{exitsMap.get(target - nums[i]),i};
            }
            //数据存入 key为补数，value为下标
            exitsMap.put(nums[i],i);
        }

        return new int[]{-1,-1};

    }

    public void test() {
        a = a +100;
        int a = 2;
        System.out.println(a);
    }
    public static void main(String[] args) {
        Topic1 topic1 = new Topic1();
        topic1.getClass();
        topic1.test();
    }
}
