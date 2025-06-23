package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/linked-list-cycle/
 *
 * @author wanghao
 * @date 2022/7/21 16:38
 */
public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fi = head;
        ListNode se = head.next;
        while (se != null && se.next != null) {
            fi = fi.next;
            se = se.next.next;

            if (fi == se) return true;
        }
        return false;
    }
}
