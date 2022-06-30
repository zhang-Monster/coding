package learn.algorithm.leetcode.easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/30 下午5:15
 */
public class Topic20 {

    /**
     * 暴力搜索这一组括号，遇到左括号入栈，遇到右括号，我们拿这个右括号跟栈顶进行比较
     * 如果能匹配，那么目前为止，这组括号有效，如果不能匹配，直接返回false
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int n = s.length();

        if (n % 2 == 1){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))){

                    return false;

                }

                stack.pop();

            }else {
                // 左括号入栈
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
