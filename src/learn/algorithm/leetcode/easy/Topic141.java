package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/30 下午5:43
 */
public class Topic141 {

    /**
     * 哈希表
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }

            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        // 定义fast = head.next 是为了保证能进入循环条件
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
