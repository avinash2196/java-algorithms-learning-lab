package meta.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class SimplifiedPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque();
        for (String curr : paths) {
            if (curr.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!curr.equals(".") && !curr.isEmpty()) {
                stack.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            String curr = it.next();
            sb.append("/").append(curr);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
// Time complexity :O(n)
// Space Complexity :O(n)