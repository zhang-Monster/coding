package learn;

import learn.leetcode.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/10/21 下午7:06
 */
public class Test {

    public ListNode ReverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;

        ListNode newHead = ReverseList(next);

        next.next = head;

        return head;

    }


    public ListNode ReverseList2(ListNode head) {
        // 虚拟头节点
        ListNode newList = new ListNode(-1);

        while (head != null) {
            ListNode next = head.next;
            head.next = newList.next;
            newList.next = head;
            head = next;
        }

        return newList.next;
    }
}
