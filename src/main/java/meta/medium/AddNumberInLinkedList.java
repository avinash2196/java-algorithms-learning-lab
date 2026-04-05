package meta.medium;

public class AddNumberInLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode();
        ListNode node = head;

        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            node.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;
        }
        if (carry != 0) node.next = new ListNode(carry);
        return head.next;
    }
}
// Time complexity :O(max(m,n))
// Space Complexity :O(max(m,n))