import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        
        int deploy = 0;
        for (int i = 0; i < progresses.length; i++) {
            deploy = (100-progresses[i])%speeds[i] == 0 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i]+1;
                
            deque.offer(deploy);
        }
        
        while (!deque.isEmpty()) {
            int day = deque.pollFirst();
            int count = 1;
            while (!deque.isEmpty() && deque.peek() <= day) {
				count++;
                deque.poll();
            }
            result.add(count);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}