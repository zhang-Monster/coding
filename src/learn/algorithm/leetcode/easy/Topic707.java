package learn.algorithm.leetcode.easy;

import learn.algorithm.common.ListNode;

/**
 * @version V1.0
 * @author: zhangkun
 * @Description:
 * @date Created in 2021/8/17 上午11:35
 */
public class Topic707 {

    /**
     * size存储链表元素的个数
     */
    int size;

    ListNode head;

    /**
     * 初始化链表
     */
    public Topic707() {
        size = 0;
        // 虚拟头指针
        head = new ListNode(-1);
    }

    /**
     * 获取链表中第index个节点的值。如果索引无效，则返回-1
     * @param index
     * @return
     */
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    /**
     * 在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /**
     * 将值为val的节点追加到链表的最后一个元素
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    /**
     * 在第index个节点之前插入一个新节点，如果index为0,那么新插入的节点为链表的新头节点
     * 如果index等于链表的长度，则说明新插入的节点为链表的尾节点
     * 如果index大于链表的长度，则返回空
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size ++;

        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }

        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    /**
     * 如果索引有效，则删除链表中的第index个节点
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size --;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}
