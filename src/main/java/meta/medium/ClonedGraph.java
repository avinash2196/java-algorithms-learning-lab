package meta.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClonedGraph {
    private Map<Node, Node> map = new HashMap();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clonedNode = new Node(node.val);
        clonedNode.neighbors = new ArrayList();
        map.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }
        return clonedNode;
    }
}
// Time complexity :O(N+E)
// Space Complexity :O(N)