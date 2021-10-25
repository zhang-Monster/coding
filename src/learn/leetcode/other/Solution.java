package learn.leetcode.other;

import learn.leetcode.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/9/16 上午9:51
 */
public class Solution {
    /**
     *
     * @param head ListNode类
     * @param m int整型
     * @param n int整型
     * @return ListNode类
     */
    public ListNode reverseBetween (ListNode head, int m, int n) {
        if(head == null || m >= n) {
            return head;
        }
        // 记录m前面的位置
        ListNode bNode = null;
        // 记录n后面的位置
        ListNode eNode = null;
        //当前节点
        ListNode cur = head;
        // 循环找到开始反转的位置
        for(int i = 0; i < m - 1; i++) {
            if(cur == null) {
                return head;
            }
            bNode = cur;
            cur = cur.next;
        }
        eNode = cur;

        //当前节点的下一个节点
        ListNode nNode = cur.next;
        //next.next
        ListNode nnNode = null;
        //循环进行反转
        for(int i = 0; i < n-m; i++) {
            //next不为空
            if(nNode != null) {
                //保存next.next
                nnNode = nNode.next;
                // 反转
                nNode.next = cur;
                cur = nNode;

                if(nnNode == null) {
                    break;
                }
                nNode = nnNode;
            }
        }


        // 反转完成 挂链
        bNode.next = cur;
        eNode.next = nnNode;

        return head;

    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
