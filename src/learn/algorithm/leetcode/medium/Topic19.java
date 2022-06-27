package learn.algorithm.leetcode.medium;

import learn.algorithm.common.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/18 下午2:25
 */
public class Topic19 {


    /**
     * 计算链表长度的方法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);

        int length = getLength(head);

        ListNode cur = dummy;

        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummy.next;

    }

    /**
     * 获取链表的长度
     * @param head
     * @return
     */
    public int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }

        return len;

    }


    /**
     * 利用栈进行处理
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(-1,head);

        Deque<ListNode> stack = new LinkedList<ListNode>();

        ListNode cur = dummy;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        for (int i = 0; i < n; i++) {
            stack.pop();
        }

        ListNode prev = stack.peek();
        prev.next = prev.next.next;

        return dummy.next;

    }

    /**
     * 双指针解法
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // 虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        // 快慢指针保持n的距离 当fast到尾部null slow到被删除节点
        while (n-- > 0) {
            fast = fast.next;
        }

        // 记录待删除节点的前一个节点
        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            fast = fast.next;
            slow = slow.next;
        }

        prev.next = slow.next;

        return dummyNode.next;

    }
}
