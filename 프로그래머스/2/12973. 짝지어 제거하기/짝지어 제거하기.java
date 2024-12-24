import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Deque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (queue.isEmpty() || queue.peek() != s.charAt(i)) {
                queue.push(s.charAt(i));
                continue;
            }
            
            queue.pop();
        }
        
        return queue.isEmpty() == true ? 1 : 0;
    }
}