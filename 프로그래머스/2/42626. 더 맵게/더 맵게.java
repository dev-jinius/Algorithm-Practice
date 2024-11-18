import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int scov : scoville) 
            pq.add(scov);
       
        int count = 0;
        int current = -1;
        
        while (pq.peek() < K) {
            if (pq.size() == 1) return -1;
            
            current = pq.poll();
            current = current + (pq.poll()*2);
            pq.add(current);
            count++;
        }
        
        return count;
    }
}