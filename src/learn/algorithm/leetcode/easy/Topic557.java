package learn.algorithm.leetcode.easy;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/24 上午10:54
 */
public class Topic557 {

    /**
     * 分割 局部反转
     * StringBuilder 效率比 string快很多
     * @param s
     * @return
     */
    public static String reverseWords(String s) {


        String[] array = s.split(" ");

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(new StringBuilder(array[i]).reverse());

            if (i != array.length - 1) {
                builder.append(" ");
            }

        }

        return builder.toString();
    }



    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        String re = reverseWords(s);
        System.out.println(re);
    }
}
