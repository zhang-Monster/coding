package learn.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/15 下午4:52
 */
public class Topic350 {

    /**
     * 暴力破解 待优化
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        List<Integer> collect = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> collect2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());


        for (int i = 0; i < collect.size(); i++) {
            for (int j = 0; j < collect2.size(); j++) {
                if (collect.get(i).equals(collect2.get(j))) {
                    res.add(collect.get(i));
                    collect2.remove(j);
                    break;
                }
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    /**
     * 哈希表
     * 遍历较短数组 用哈希表存储每个数组出现的次数
     * 对于一个数字，在交集中出现的次数等于该数字在两个数组中出现次数的最小值
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2){

        // 降低空间复杂度 维护较短的数组在哈希表
        if (nums1.length > nums2.length) {
            return intersect2(nums2,nums1);

        }
        ArrayList<Integer> res = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            if (map.containsKey(i)) {
                map.put(i,map.get(i) + 1);
                continue;
            }
            map.put(i,1);
        }

        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0){
                res.add(i);
                map.put(i,map.get(i) - 1);
            }
        }


        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    /**
     * 数组排序 + 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect3(int[] nums1, int[] nums2){


        ArrayList<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int index1 = 0;
        int index2 = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                index1 ++;
            }else if (nums1[index1] > nums2[index2]) {
                index2 ++;
            }else {
                res.add(nums1[index1]);
                index1 ++;
                index2 ++;
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};
//        int nums1[] = {1,2,2,1};
//        int nums2[] = {2};

        System.out.println(Arrays.toString(intersect3(nums1,nums2)));


    }
}
