package meta.medium.LinkedList;

public class InsertIntoCircularList {
    private class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        //empty nodes
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        //get prev  and curr for circular references
        Node prev = head;
        Node curr = head.next;
        //need to run atleast once to as we start with head==prev
        do {
            //normal insertion
            if (insertVal >= prev.val && insertVal <= curr.val) {
                break;
            }
            //this is wrap point
            if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    break;
                }
            }
            prev = curr;
            curr = curr.next;

        } while (prev != head);
        prev.next = new Node(insertVal, curr);
        return head;
    }
}
  /*
        Time & Space Complexity
        Complexity	Value
        Time	    O(n) — worst-case single pass through the circular list
        Space   	O(1) — constant auxiliary space*/
