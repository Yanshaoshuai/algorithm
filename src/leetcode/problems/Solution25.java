package leetcode.problems;


import leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2025/12/16
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start = head;
        ListNode end = head;
        int count = 1;
        while (end != null) {
            if (count == k) {
                ListNode nextStart = end.next;
                end.next = null;
                pre.next = reverseList(start);
                pre = start;
                start = nextStart;
                end = nextStart;
                count = 1;
            } else {
                end = end.next;
                count++;
            }
        }
        if (start != end) {
            pre.next = start;
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new Solution25().reverseList(ListNode.createLinkedList(new int[]{1, 2, 3, 4}));
        ListNode.printLinkedList(head);
    }
}
