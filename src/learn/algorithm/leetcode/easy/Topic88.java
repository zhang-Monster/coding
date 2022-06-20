package learn.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/12 下午4:33
 */
public class Topic88 {

    /**
     * 将nums2合并到nums1后sort排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m++] = nums2[i];
        }

        Arrays.sort(nums1);

        System.out.println(Arrays.toString(nums1));

    }

    /**
     * 双指针的思路
     * 开辟额外的数组空间进行暂存
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        // 临时空间进行暂存
        int[] sorted = new int[m + n];
        int  cur = 0;

        while (p1 < m || p2 < n) {
            if (p1 == m ) {
                cur = nums2[p2];
                p2++;
            }else if (p2 == n ) {
                cur = nums1[p1];
                p1++;
            }else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1];
                p1++;
            }else {
                cur = nums2[p2];
                p2++;

            }

            // 找到新数组中对应的下标
            sorted[p1 + p2 - 1] = cur;
        }

//        // 这种数组直接覆盖的方式 leetcode自带编译器无法通过
//        nums1 = sorted;

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = sorted[i];
        }

        System.out.println(Arrays.toString(nums1));

    }


    /**
     * 逆向双指针
     * nums1的后半部分为空，可以直接覆盖而不会产生影响，因此指针可以设置从后向前遍历
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1 ;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur;

        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            }else if (p2 == -1) {
                cur = nums1[p1--];
            }else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            }else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }

        System.out.println(Arrays.toString(nums1));

    }

    public static void main(String[] args) {

        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        merge3(nums1,3,nums2,3);

//        int nums1[] = {1,2};
//        int nums2[] = {1,2,3,4};
//        nums2 = nums1;
//        System.out.println(Arrays.toString(nums2));
    }
}
