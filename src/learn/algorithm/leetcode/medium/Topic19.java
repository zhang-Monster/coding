package learn.algorithm.leetcode.medium;

import learn.algorithm.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/18 下午2:25
 */
public class Topic19 {

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
