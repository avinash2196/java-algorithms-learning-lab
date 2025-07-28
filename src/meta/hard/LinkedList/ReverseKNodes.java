package meta.hard.LinkedList;

import meta.ListNode;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode curr = head, kTail = dummy;
        ListNode newHead = null;
        while (curr != null) {
            int counter = 0;
            ListNode temp = curr;
            while (counter < k && temp != null) {
                counter++;
                temp = temp.next;
            }
            if (k == counter) {
                ListNode revHead = reverseNode(curr, k);
                kTail.next = revHead;
                kTail = curr;
                curr = temp;
            } else {
                kTail.next = curr;
                break;
            }
        }
        return dummy.next;
    }


    private ListNode reverseNode(ListNode node, int k) {
        ListNode prev = null, next = null;
        while (k > 0) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
            k--;
        }
        return prev;
    }


}
