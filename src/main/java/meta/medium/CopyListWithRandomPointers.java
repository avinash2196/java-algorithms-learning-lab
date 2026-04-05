package meta.medium;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointers {
    private class Node {
        int val;
        Node random, next;

        Node(int val) {
            this.val = val;
        }
    }

    private Map<Node, Node> map = new HashMap();

    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node newNode = new Node(head.val);
        Node oldNode = head;
        map.put(oldNode, newNode);
        while (oldNode != null) {
            newNode.next = getCloneNode(oldNode.next);
            newNode.random = getCloneNode(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return map.get(head);
    }

    private Node getCloneNode(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        } else {
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            return newNode;
        }

    }
}
// Time complexity :O(N)
// Space Complexity :O(N)