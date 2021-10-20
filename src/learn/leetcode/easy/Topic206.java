package learn.leetcode.easy;

import learn.leetcode.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/17 下午3:33
 */
public class Topic206 {

    /**
     * 反转链表 如果再重新定义一个新的链表，实现链表元素的反转，其实就是对内存空间的浪费
     * 其实我们只需要改变链表的next指针的指向，直接将链表反转，而不用重新定义一个新的链表
     * 双指针法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode tmp = null;
        ListNode prev = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;
        ListNode reverseHead = reverseList2(second);
        second.next = head;
        head.next = null;
        return reverseHead;
    }
}
