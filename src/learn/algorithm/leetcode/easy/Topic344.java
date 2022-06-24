package learn.algorithm.leetcode.easy;


/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/24 上午10:28
 */
public class Topic344 {

    /**
     * 双指针解法
     * @param s
     */
    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        char tmp;

        while (left <= right ) {

            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left ++;
            right --;
        }


        return;

    }


    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};

        reverseString(s);

        System.out.println(s);

    }
}
