package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 *
 * @author wanghao
 * @date 2022/7/21 15:45
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
