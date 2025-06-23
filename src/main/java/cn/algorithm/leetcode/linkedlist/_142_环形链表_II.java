package cn.algorithm.leetcode.linkedlist;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 *
 * @author wanghao
 * @date 2022/7/22 10:34
 */
public class _142_环形链表_II {

    public ListNode detectCycle(ListNode head) {
        int cLen = isCycle(head);
        if (cLen == 1) return null;
        ListNode tmp;
        for (int i = 0; i <= cLen; i++) {
            tmp = head;
            for (int j = i; j < cLen; j++) {
                tmp = tmp.next;
                if (head == tmp) return tmp;
            }
            head = head.next;
        }
        return null;
    }

    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public int isCycle(ListNode head) {
        if (head == null || head.next == null) return 1;
        ListNode one = head;
        ListNode two = head.next;
        int len = 1;
        while (two != null && two.next != null) {
            one = one.next;
            two = two.next.next;
            len += 2;
            if (one == two) return len;
        }
        return 1;
    }
}
