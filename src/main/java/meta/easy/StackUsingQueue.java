package meta.easy;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    class MyStack {
        Queue<Integer> queue;
        MyStack(){
            queue=new LinkedList<>();
        }
        void push(int x){ //Pushes element x to the top of the stack.
            queue.add(x);
            int size=queue.size();
            while(size-->1){
                queue.add(queue.remove());
            }
        }
        int pop(){// Removes the element on the top of the stack and returns it.
            return queue.remove();
        }
        int top(){// Returns the element on the top of the stack.
            return queue.peek();
        }
        boolean empty(){
            return queue.isEmpty();
        }
    }
}

// Time complexity : push : O(n) , pop : O(1) , top : O(1) , empty : O(1)
// Space Complexity :O(n)
