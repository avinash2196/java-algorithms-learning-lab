package meta.medium.BinaryTree;

import meta.medium.TreeNode;

public class LowestCommonAncestorOfTree3HavingParentPointer {
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }


    public Node lowestCommonAncestor(Node p, Node q) {
        //similar to Linked List intersaction
        Node a = p;
        Node b = q;
        //keep iterating and make both length equal by pointing to other node
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
// Time complexity : O(n)
// Space Complexity :O(h)