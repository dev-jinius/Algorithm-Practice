import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int mix = 0;
        int first = 0;
        int second = 0;
        while (pq.peek() < K) {            
            first = pq.poll();
            second = pq.poll();
            mix = first + second*2;
            pq.offer(mix);
            answer++;
            
            if (pq.peek() >= K) return answer;
            if (pq.size() == 1) return -1;
        }
        
        return answer;
    }
}