package meta.medium;

public class BinaryTreeToSortedDoublyLinkedList {
    // Definition for a Node
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);

        // Close the circular doubly linked list
        last.right = first;
        first.left = last;

        return first;
    }

    private void helper(Node node) {
        if (node == null) return;

        // In-order traversal: left → node → right
        helper(node.left);

        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node; // first node in in-order will be the smallest
        }

        last = node; // move last pointer

        helper(node.right);
    }
}


/* Time and Space Complexity
        Time Complexity: O(n) – Each node is visited once.

        Space Complexity:

        O(h) – Recursion stack (h is the height of the tree)

        O(log n) for balanced trees, O(n) for skewed trees */