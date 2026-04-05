package meta.medium;

import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {// Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
        stack = new Stack();
        pushLeftPath(root);
    }

    public boolean hasNext() {// Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
        return stack.isEmpty();
    }

    public int next() {// Moves the pointer to the right, then returns the number at the pointer.
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeftPath(node.right);
        }
        return node.val;
    }

    private void pushLeftPath(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

