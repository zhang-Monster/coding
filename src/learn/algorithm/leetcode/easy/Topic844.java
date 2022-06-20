package learn.algorithm.leetcode.easy;


import java.util.Stack;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/10 上午10:06
 */
public class Topic844 {

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    /**
     * 通过栈重新构建新的字符串
     * @param str
     * @return
     */
    public String build(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '#') {
                stack.push(ch);
            }else {
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }
        }
        return stack.toString();
    }


    public static void main(String[] args) {
        System.out.println(new Topic844().backspaceCompare("a#c","b"));
    }
}
