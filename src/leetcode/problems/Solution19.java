package leetcode.problems;


import leetcode.problems.utils.ListNode;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        // [1] n=1 -> []
        ListNode slow = dummy;
        //fast先走n步 走完后在第n+1个节点
        //[1,2,3,4,5] n=2 => fast=3 slow->-1
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        //再一起走 直到fast到达末尾 slow落后n+1步再到数第n+1个节点
        //[1,2,3,4,5] n=2 => fast=6 slow->3 要删除的是倒数第二个->4
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //1<=n<=length slow.next!=null
        slow.next = slow.next.next;
        return dummy.next;
    }
}
