package learn.algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangkun
 * @Description: 杨辉三角的升级版 只输出指定行
 * @date Created in 2022/4/12 上午11:24
 */
public class Topic119 {
    /**
     * 暴力解法 推出杨辉三角的全部二维数组 获取指定row的数组
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
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

        return result.get(rowIndex);

    }

    /**
     * 优化一：对第i+1行的计算仅用到了第i行的数据，因此可以使用滚动数组的思想优化空间复杂度
     * 不用保存全量，只保存上一行
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow2(int rowIndex){

        List<Integer> pre = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                }else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = cur;
        }

        return pre;
    }


    /**
     * 优化二：只用一个数组
     * 当前行第i项只与上一行第i-1项和i项相关
     * 而且每一行都会比上一行多一个 每次在当前行新增一个元素
     * 数组中保存的也是上一行的数据，从数组最后一个元素逐一计算修改数组元素
     * ⚠️：要保证从最后一位开始计算
     * 因为我们只使用了一个数组
     * 如果从头开始计算会将计算后的值保存到数组中 影响后续的计算
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add(0);
            for (int j = i; j > 0 ; j--) {
                row.set(j , row.get(j) + row.get(j - 1));
            }

        }
        return row;

    }



    public static void main(String[] args) {
        System.out.println(getRow3(3));
    }
}
