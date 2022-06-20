package learn.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/16 下午2:24
 */
public class Topic904 {

    /**
     * 套用滑动窗口的模版
     * @param tree
     * @return
     */
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0){
            return 0;
        }
        int n = tree.length;

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            // getOrDefault(Object key, V defaultValue) 当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
            // 右边界
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            // while循环可以简单理解为左指针左移
            // 不符合条件：水果种类大于2
            while (map.size() > 2) {
                //缩进左边界时，减少频次。
                map.put(tree[left], map.get(tree[left]) - 1);
                //如果值为0直接移除这个元素
                if (map.get(tree[left]) == 0) {
                    map.remove(tree[left]);
                }
                // 左边界
                left++;
            }
            // 更新结果
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums ={3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new Topic904().totalFruit(nums));
    }
}
