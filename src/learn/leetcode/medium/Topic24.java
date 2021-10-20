package learn.leetcode.medium;

import learn.leetcode.common.ListNode;


/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/17 下午4:23
 */
public class Topic24 {

    /**
     * 虚拟头节点
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            // 缓存next
            ListNode tmp = head.next.next;
            prev.next = head.next;
            head.next.next = head;
            head.next = tmp;
            prev = head;
            head = head.next;
        }

        return dummyNode.next;
    }

    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null ) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = swapPairs2(next.next);
        next.next = head;
        head.next = newNode;

        return next;
    }

}
