package learn.leetcode.hard;

import learn.leetcode.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description: k个一组反转链表
 * @date Created in 2021/9/10 下午2:28
 */
public class Topic25 {

    /**
     * 解题思路：我们需要把链表节点按照k个一组进行分组，所以可使用一个指针head依次指向每组的头节点。这个指针每次向前移动k步，
     * 直至链表结尾。对于每个分组，我们需要先判断它的长度是否大于等于k。
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        // 虚拟头节点
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;

        while (head != null) {
            ListNode tail = prev;
            // 查看剩余部分长度是否大于等于k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head,tail);
            head = reverse[0];
            tail = reverse[1];

            // 把子链表重新接回原链表
            prev.next = head;
            tail.next = nex;
            prev = tail;
            head = tail.next;

        }
        return hair.next;
    }


    /**
     * 子模块的链表进行反转
     * @param head
     * @param tail
     * @return
     */
    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }

        return new ListNode[]{tail,head};

    }
}
