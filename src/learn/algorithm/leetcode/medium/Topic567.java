package learn.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/27 下午3:12
 */
public class Topic567 {

    /**
     * 滑动窗口
     * 排列不会改变字符串中每个字符的个数
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }

        // 统计字符串中各字符的个数
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        // 统计s1中每个字符出现的次数
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        // 根据字符出现的个数判断是否含有子序列
        if (Arrays.equals(cnt1,cnt2)) {
            return true;
        }

        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;

            if (Arrays.equals(cnt1,cnt2)) {
                return true;
            }
        }

        return false;

    }
}
