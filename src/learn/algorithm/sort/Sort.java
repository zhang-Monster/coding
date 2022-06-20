package learn.algorithm.sort;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/6/1 下午6:08
 */
public class Sort {

    //TODO 这里想的是把交换这个方法抽出来 但是涉及到值传递和引用传递的问题 需要用反射 先这样放着吧
//    public static void swap(Integer a ,Integer b){
//
//        // 方法一：中间变量
//        // 方法二： 数学计算（容易溢出）
//        a = a + b;
//        b = a - b;
//        a = a - b;
//        // 方法三：位运算
//        a ^= b;
//        b ^= a;
//        a ^= b;
//
//    }

    /**
     * 交换数组指定两个下标的值
     * @param array
     * @param a
     * @param b
     */
    public static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /**
     * 冒泡排序
     * 实现思路：每次循环找到最大/最小的一个放到最后
     * 稳定性：稳定
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int len = array.length;

        // 外层循环控制比较次数
        for (int i = 0; i < len - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < len - 1 - i ; j++) {
                if (array[j] > array[j+1]) {
                    // 进行交换
                    array[j] ^= array[j+1];
                    array[j+1] ^= array[j];
                    array[j] ^= array[j+1];
                    flag = false;
                }
            }

            if (flag) break;
        }
    }

    /**
     * 选择排序
     * 实现思路：在未排序的序列中找到最小（大）的元素，放到已排序序列的末尾
     * 稳定性：不稳定(交换后会改变元素的前后位置 会导致不稳定)
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int len = array.length;

        // 外层循环控制循环次数
        for (int i = 0; i < len - 1; i++) {
            int flag = i;

            for (int j = i+1; j < len ; j++) {
                if (array[j] < array[flag]) {
                    flag = j;
                }
            }

            if (flag != i) {
                swap(array,flag,i);
            }

        }

    }

    /**
     * 插入排序
     * 实现思路：构建有序序列，对于未排序的数据，在已排序序列中从后向前扫描
     * 稳定性：稳定
     * @param array
     */
    public static void insertSort(int[] array) {
        if(array == null || array.length <= 1) {
            return;
        }

        int len = array.length;

        for (int i = 1 ;i < len ; i++) {
            int insertOne = array[i];

            // 已排好的序列
            int j = i-1;
            while (j >= 0 && array[j] > insertOne) {
                array[j+1] = array[j];
                j--;
            }

            array[j + 1] = insertOne;

        }

    }

    /**
     * 快速排序
     * 实现思路：将数组根据基准元素进行划分，采用递归的方式，对两部分分别进行排序
     * 稳定性：不稳定
     * @param array
     */
    public static void quickSort(int[] array,int low,int high) {
        int p,i,j,temp;
        if (low >= high) {
            return;
        }

        // 基准数，这里我们默认为每一个数组的第一个
        p = array[low];
        i = low;
        j = high;

        while (i < j) {
            // 右边发现小于基准元素的值就停止循环
            while (array[j] >= p && i < j) {
                j--;
            }

            // 左边发现大于基准元素的值就停止循环
            while (array[i] <= p && i < j) {
                i ++;
            }

            // 交换两个元素的位置
            temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        // 这里arr[i]一定是小于p的 经过i、j交换后i处的值一定是小于p的
        array[low] = array[i];
        array[i] = p;
        quickSort(array,low,j-1);
        quickSort(array,j+1,high);
    }



    public static void main(String[] args){
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 5, 4, 19, 50, 48};

        // 冒泡排序
//        bubbleSort(array);

        // 选择排序
//        selectSort(array);

        // 插入排序
//        insertSort(array);

        // 快速排序
//        quickSort(array,0, array.length - 1);

//        System.out.println(Arrays.toString(array));

    }
}
