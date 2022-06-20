package learn.algorithm.other;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: 两个大数相加
 * @date Created in 2021/10/21 下午2:31
 */
public class SumBigData {


    public static String sum(String n1,String n2) {
        StringBuilder result = new StringBuilder();

        // 对两个字符串进行反转
        n1 = new StringBuilder(n1).reverse().toString();
        n2 = new StringBuilder(n2).reverse().toString();

        int len1 = n1.length();
        int len2 = n2.length();

        int maxLen = len1 > len2 ? len1 : len2;

        // 进位
        int flag = 0;

        // 将两个字符串长度补齐
        if (len1 < len2) {

            for (int i = len1 ; i < maxLen; i++) {
                n1 += '0';
            }

        }else if (len1 > len2) {
            for (int i = len2; i < maxLen; i++) {
                n2 += '0';
            }

        }

//        System.out.println(n1);
//        System.out.println(n2);

        for (int i = 0; i < maxLen; i++) {
            int sum = Integer.parseInt(n1.charAt(i) + "") + Integer.parseInt(n2.charAt(i) + "") + flag;
            int mod = sum % 10;
            result.append(mod);
            flag = sum / 10;
        }

        // 最高位进行进位
        if (flag > 0) {
            result.append(flag);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(SumBigData.sum("9544545455454545454545543232332442342423424", "9564565465444543535353454354353453"));
    }
}
