package learn.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/4/12 上午10:40
 */
public class Topic118 {

    /**
     * 利用杨辉三角的定义暴力计算
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(list);
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(generate(2));
    }
}
