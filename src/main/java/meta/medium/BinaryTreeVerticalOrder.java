package meta.medium;

import java.util.*;

public class BinaryTreeVerticalOrder {
    private class Pair {
        TreeNode key;
        int val;

        Pair(TreeNode key, int val) {
            this.key = key;
            this.val = val;
        }

        public TreeNode getKey() {
            return key;
        }

        public int getValue() {
            return val;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 0));
        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            columnMap.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (node.left != null) {
                queue.offer(new Pair(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair(node.right, column + 1));
            }
        }

        for (int col = minColumn; col <= maxColumn; col++) {
            result.add(columnMap.get(col));
        }

        return result;
    }
}
