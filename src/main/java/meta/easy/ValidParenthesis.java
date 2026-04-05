package meta.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Valid Parentheses — LeetCode #20 (Easy)
 *
 * <p><b>Problem:</b> Given a string of brackets, determine whether the open brackets are
 * closed in the correct order.
 *
 * <p><b>Concept:</b> Stack-based bracket matching. Closing brackets must match the
 * most recently seen opening bracket — exactly what a stack (LIFO) models.
 *
 * <p><b>Real-world relevance:</b> Compilers, IDEs, JSON/XML parsers, and expression
 * evaluators all use this exact technique to validate syntax.
 *
 * <p>Time: O(n) | Space: O(n)
 */
public class ValidParenthesis {

    /**
     * Uses a stack to ensure every closing bracket matches the last unmatched opener.
     *
     * <p><b>Design note:</b> Storing the expected opener in the map (closing → opening)
     * keeps the match logic in one place and avoids a chain of if/else comparisons.
     *
     * @param s string containing only {@code '('}, {@code ')'}, {@code '{'}, {@code '}'},
     *          {@code '['}, {@code ']'}
     * @return {@code true} if {@code s} is valid, {@code false} otherwise
     */
    public boolean isValid(String s) {
        Map<Character,Character> charMap=new HashMap();
        charMap.put(')','(');
        charMap.put('}','{');
        charMap.put(']','[');
        Stack<Character> stack=new Stack();
        for(int index=0;index<s.length();index++){
            char currSymbol=s.charAt(index);
            if(charMap.containsKey(currSymbol)){
                char topElement=stack.isEmpty()?'#':stack.pop();
                char expectedElement=charMap.get(currSymbol);
                if(topElement!=expectedElement){
                    return false;
                }
            }else{
                stack.push(currSymbol);
            }
        }
        return stack.isEmpty();
    }
    // Time complexity :O(n)
    // Space Complexity :O(n)
}
