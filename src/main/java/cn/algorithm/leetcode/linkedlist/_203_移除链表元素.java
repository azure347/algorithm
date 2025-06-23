package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/remove-linked-list-elements/
 *
 * @author wanghao
 * @date 2022/7/21 16:49
 */
public class _203_移除链表元素 {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode newNode = removeElements(head.next, val);
        if (head.val == val) {
            return newNode;
        } else {
            head.next = newNode;
            return head;
        }
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        a.next = new ListNode(3);
        a.next = new ListNode(4);
        a.next = new ListNode(5);
        a.next = new ListNode(3);

        ListNode listNode = removeElements(a, 5);
        System.out.println(listNode);
    }
}
