package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author wanghao
 * @date 2022/7/21 16:01
 */
public class _206_反转链表 {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 非递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newNode;
            newNode = head;
            head = tmp;
        }
        return newNode;
    }
}
