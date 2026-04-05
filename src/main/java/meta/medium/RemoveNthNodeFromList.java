package meta.medium;

public class RemoveNthNodeFromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode fast = node;
        ListNode slow = node;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return node.next;
    }
}
// Time complexity :O(L)
// Space Complexity :O(1)