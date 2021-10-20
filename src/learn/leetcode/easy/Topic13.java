package learn.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/7/30 下午3:41
 */
public class Topic13 {



    /**
     * 这种写法替换字符串的写法 通俗易懂
     * 就是这个效率有点低。。
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        Map<Character,Integer> keyMap = new HashMap<>();
        keyMap.put('I',1);
        keyMap.put('V',5);
        keyMap.put('X',10);
        keyMap.put('L',50);
        keyMap.put('C',100);
        keyMap.put('D',500);
        keyMap.put('M',1000);
        keyMap.put('a',4);
        keyMap.put('b',9);
        keyMap.put('c',40);
        keyMap.put('d',90);
        keyMap.put('e',400);
        keyMap.put('f',900);

        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            res += keyMap.get(s.charAt(i));
        }

        return res;
    }


    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    /**
     * 通常情况下，罗马数字中小的数字在搭的数字的右边，可以将每个字符视作一个单独的值，累加每个字符对应的数值即可。
     * 若存在小的数字在大的数字的左边的情况，根据规则需要减去小的数字，对于这种情况，我们也可以将每个字符视作一个单独的值，
     * 若一个数字右侧的数字比它大，则将改数字的符号取反。
     * @param s
     * @return
     */
    public int romanToInt2(String s){
        int res = 0;
        int len = s.length();
        for (int i = 0; i < len ; i++ ){
            int value = symbolValues.get(s.charAt(i));
            if (i < len - 1 && value < symbolValues.get(s.charAt(i + 1))){
                res -= value;
            }else {
                res += value;
            }
        }

        return res;

    }


    public static void main(String[] args) {
        int result = new Topic13().romanToInt2("XIV");
        System.out.println(result);

    }
}
