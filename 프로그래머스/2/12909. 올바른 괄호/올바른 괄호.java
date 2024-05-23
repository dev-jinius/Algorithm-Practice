import java.util.*;

class Solution {
    boolean solution(String s) {
        
        var stack = new Stack<Character>();
        
        var chars = s.toCharArray();
        
        for (char c : chars) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            
            if (stack.isEmpty()) return false;
            
            stack.pop();
        }
        
        return stack.isEmpty();
    }
}