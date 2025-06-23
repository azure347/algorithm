package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 *
 * @author wanghao
 * @date 2022/7/21 18:09
 */
public class _876_链表的中间结点 {

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode tmp = head;
        while (head != null) {
            len++;
            head = head.next;
        }
        int index = len / 2;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2));
        l.next.next = new ListNode(3, new ListNode(4));
        l.next.next.next.next = new ListNode(5);
        ListNode listNode = middleNode(l);
        System.out.println(listNode);

//        System.out.println(4 % 2);
//        System.out.println(4 / 2);
//        System.out.println(5 / 2);
    }
}
