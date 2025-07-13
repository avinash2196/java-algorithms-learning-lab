package meta.medium.LinkedList;

import meta.TreeNode;

import java.util.*;

public class VerticalListTraversal {
    private static class Triplet {
        TreeNode node;
        int row;
        int col;

        Triplet(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> columnRowMap = new TreeMap<>();
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(root, 0, 0));
        while (!queue.isEmpty()) {
            Triplet currElement = queue.poll();
            int row = currElement.row;
            int col = currElement.col;
            TreeNode node = currElement.node;
            columnRowMap.computeIfAbsent(col, k -> new TreeMap<Integer, PriorityQueue<Integer>>()).computeIfAbsent(row, k -> new PriorityQueue<Integer>()).add(node.val);
            if (node.left != null) {
                queue.offer(new Triplet(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                queue.offer(new Triplet(node.right, row + 1, col + 1));
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> rowMap : columnRowMap.values()) {
            List<Integer> columnList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rowMap.values()) {
                while (!pq.isEmpty()) {
                    columnList.add(pq.poll());
                }
            }
            result.add(columnList);
        }
        return result;
    }
/*    Time and Space Complexity
     Time	O(n log n)
    Space	O(n)*/
}
