import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() == ')') return false;
                stack.pop();
            } else {
            	if (!stack.isEmpty() && stack.peek() == ')') return false;
                stack.push(c);
            }
        }
			
        return stack.isEmpty();
    }
}