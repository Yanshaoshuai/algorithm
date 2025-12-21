package leetcode.problems.list;

import leetcode.problems.utils.ListNode;

/**
 * @Author Mr.Yan
 * @Date 2020 / 09 /04 21:30
 **/
public class Solution24 {
    /**
     * 记录前一个节点pre p1,p2指向要交换的第一个和第二个元素
     * 交换后更新前置指针pre.next->p2 pre=p1
     * 更新p1,p2继续下一组
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            p1.next = p2.next;
            p2.next = p1;
            pre.next = p2;
            pre = p1;
            if (p1.next == null) {
                break;
            }
            p1 = p1.next;
            p2 = p1.next;
        }
        return dummy.next;
    }
}
