package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 *
 * @author wanghao
 * @date 2022/7/21 18:00
 */
public class _83_删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode listNode = deleteDuplicates(head.next);
        if (head == listNode) {
            return listNode;
        } else {
            head.next = listNode;
            return head;
        }
    }
}
