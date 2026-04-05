package meta.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface NestedInteger {
    // Constructor initializes an empty nested list.

    // Constructor initializes a single integer.

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // The result is undefined if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // The result is undefined if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class NestedListWeightSum {


    public int depthSum(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        int depth = 1;
        int totalSum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) {
                    totalSum += current.getInteger() * depth;
                } else {
                    queue.addAll(current.getList());
                }
            }
            depth++;
        }

        return totalSum;
    }
}

/*
    Time Complexity: O(n) — where n is the total number of NestedInteger elements (including inner lists).
    Space Complexity: O(w) — where w is the maximum number of nested elements at any level (i.e., the queue size).
*/