package meta.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) return lists[0];
        ListNode mergedList = lists[0];
        for (int index = 1; index < lists.length; index++) {
            mergedList = mergeTwoList(mergedList, lists[index]);
        }
        return mergedList;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        else if (list1 == null) return list2;
        else if (list2 == null) return list1;
        else {
            ListNode head = new ListNode();
            ListNode node = head;
            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    node.next = new ListNode(list2.val);
                    list2 = list2.next;
                    node = node.next;
                } else {
                    node.next = new ListNode(list1.val);
                    list1 = list1.next;
                    node = node.next;
                }
            }
            node.next = (list1 == null) ? list2 : list1;
            return head.next;
        }
    }
/*    Time Complexity
    O(k * n), where:
    - k = number of lists
    - n = total number of nodes across all lists*/
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) {
                heap.offer(node);
            }
        }
        return dummy.next;
    }
}
   /* Time and Space Complexity
    Time Complexity: O(n log k)

        Each of the n nodes is pushed and popped from the heap once.

        Space Complexity: O(k) for the heap*/