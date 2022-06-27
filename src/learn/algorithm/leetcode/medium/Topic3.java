package learn.algorithm.leetcode.medium;

import java.util.HashMap;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/27 下午2:15
 */
public class Topic3 {

    /**
     * 滑动窗口解题
     * 解析：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // 记录最大不重复子串的长度
        int maxLen = 0;

        // 滑动窗口左指针
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // put会覆盖原先的值
            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;

    }
}
