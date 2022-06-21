package learn.algorithm.leetcode.easy;

import java.util.HashSet;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/21 下午2:22
 */
public class Topic349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        return set1.stream().mapToInt(i->i).toArray();
    }
}
