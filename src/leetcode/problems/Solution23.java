package leetcode.problems;


import leetcode.problems.utils.ListNode;

/**
 * @Author Solution
 * @Date 2025/12/16
 */
public class Solution23 {
    /**
     * 迭代所有链表 相邻两个合并后的链表和下一次个链表合并
     * O((k^2)*n)
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode root = lists[0];
        for (int i = 1; i < lists.length; i++) {
            root = mergeTwoList(root, lists[i]);
        }
        return root;
    }

    /**
     * 分治合并 两两配对合并 放到新的链表数组重复此操作
     * O(kn*logk)
     */
    public ListNode mergeKListsPlus(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int newLength = lists.length % 2 == 0 ? lists.length / 2 : lists.length / 2 + 1;
        ListNode[] newLists = new ListNode[newLength];
        int i = 0, j = lists.length - 1;
        int k = 0;
        for (; i < j; i++, j--, k++) {
            ListNode root = mergeTwoList(lists[i], lists[j]);
            newLists[k] = root;
        }
        if (i == j) {
            newLists[newLength - 1] = lists[i];
        }
        return mergeKLists(newLists);
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }

}
