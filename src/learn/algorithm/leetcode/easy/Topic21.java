package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

/**
 * @author: zhangkun
 * @Description:
 * @date Created in 2022/6/28 下午3:58
 */
public class Topic21 {

    /**
     * 迭代处理
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode preHead = new ListNode(-1);

        ListNode prev = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                prev.next = list1;
                list1 = list1.next;
            }else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;

        }

        // 循环结束后 直接将剩下的部分全部并入链表
        prev.next = list1 == null ? list2 : list1;

        return preHead.next;

    }

    /**
     * 递归解法
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }else if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }else {

            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }

    }
}
