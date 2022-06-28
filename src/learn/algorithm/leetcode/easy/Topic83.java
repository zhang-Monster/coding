package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/28 下午3:35
 */
public class Topic83 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return head;

    }
}
