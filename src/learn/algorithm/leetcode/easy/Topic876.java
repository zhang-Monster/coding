package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/27 上午10:27
 */
public class Topic876 {


    /**
     * 题目有限制 可以通过将链表转成数组的形式进行处理
     * @param head
     * @return
     */
    public static ListNode middleNode1(ListNode head) {
        ListNode[] list = new ListNode[100];
        int index = 0;

        while (head != null) {
            list[index++] = head;
            head = head.next;

        }

        return list[index / 2];

    }

    /**
     * 对数组方式的优化
     * 单指针遍历两次
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        int index = 0;
        ListNode cur = head;
        while (cur != null) {
            index ++;
            cur = cur.next;

        }

        int k = 0;
        cur = head;
        while (k < index / 2) {
            k ++;
            cur = cur.next;
        }

        return cur;

    }


    /**
     * 快慢指针（双指针）
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;


    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode node6 = new ListNode(6);
        node5.next = node6;

        ListNode node = middleNode1(head);

        System.out.println(node.val);

    }
}
