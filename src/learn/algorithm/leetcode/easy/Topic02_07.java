package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/18 下午3:54
 */
public class Topic02_07 {

    /**
     * 双指针法求两个链表是否相交
     * 计算出链表长度差 较长链表移动到指定位置
     * 然后同时进行遍历
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先计算出两个链表的长度
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;

        while (curA != null && curA.next != null) {
            lenA ++;
            curA = curA.next;
        }

        while (curB != null && curB.next != null) {
            lenB ++;
            curB = curB.next;
        }
        // 指针复位
        curA = headA;
        curB = headB;

        // TODO 不知道那个链表长 如果在进行遍历判断需要if-else判断 可以指定一个链表为长链表 如果不是 就将两个链表反转
        // 这里就默认链表A为较长的那个链表吧
        if (lenB > lenA) {
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempCur = curA;
            curA = curB;
            curB = tempCur;
        }

        // 计算长度差
        int size = lenA - lenB;
        while (size-- > 0) {
            curA = curA.next;
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;

    }
}
