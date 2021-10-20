package learn.leetcode.medium;

import learn.leetcode.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/7/21 下午2:57
 */
public class Topic2 {

    /**
     * 常规写法 非递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 预先头指针
        ListNode l3 = new ListNode(0);
        ListNode p = l3;

        int sum ;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            p.next = node;
            p = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return l3.next;
    }

    /**
     * 递归写法
     * 为什么可以使用递归？
     * 两个节点相加的过程是一样的 只是需要考虑进位 因此我们只需将进位单独记录出来 便可以考虑使用递归
     *
     * 递归函数交付给上层的是什么？
     * 交付的是两个节点相加后的值（sum % 10）
     *
     * 递归的终止条件是什么？
     * 当两个链表的指针都为null 且进位carry 为0
     *
     * @param l1
     * @param l2
     * @return
     */
    int carry = 0;

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && carry == 0 ) {
            return null;
        }
        if (l1 != null && l2 == null && carry == 0) {
            return l1;
        }else if (l1 == null && l2 != null && carry == 0){
            return l2;
        }

        int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;

        carry = sum / 10;

        int value = sum % 10;
        ListNode node = new ListNode(value);

        node.next = addTwoNumbers2(l1 == null ? null : l1.next,l2 == null ? null : l2.next);

        return node;
    }
}
