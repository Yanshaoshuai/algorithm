package leetcode.problems.list;

import leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 14:38
 **/
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int odd = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + odd;
            cur.val = sum % 10;
            odd = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            if (l1 != null || l2 != null || odd > 0) {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
        }
        ListNode l = l1 == null ? l2 : l1;
        while (l != null) {
            int sum = l.val + odd;
            cur.val = sum % 10;
            odd = sum / 10;
            l = l.next;
            if (l != null || odd > 0) {
                cur.next = new ListNode(0);
                cur = cur.next;
            }
        }
        if (odd > 0) {
            cur.val = odd;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        ListNode head = solution2.addTwoNumbers
                (ListNode.createLinkedList(new int[]{9, 9}),
                        ListNode.createLinkedList(new int[]{9}));
        ListNode.printLinkedList(head);
    }
}
