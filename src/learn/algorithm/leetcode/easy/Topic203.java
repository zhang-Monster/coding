package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/17 上午11:09
 */
public class Topic203 {

    /**
     * 移除链表中的某个元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        // 因为被删除的元素可能在链表头，所以我们可设置一个虚拟头节点 来保证链表所有的节点都可以按照统一的方式移除
        ListNode h = new ListNode(-1,head);
        ListNode p = h;
        while (p.next != null){
            if (p.next.val == val) {
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return h.next;
    }
}
