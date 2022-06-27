package learn.algorithm.common;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/7/21 下午2:55
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
