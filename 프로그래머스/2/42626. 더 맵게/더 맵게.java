import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        List<Integer> list = new LinkedList<>();
        for (int n : scoville) {
            list.add(n);
        }
        
        int mixed = 0;
        while (true) {
            
            Collections.sort(list);
            if (list.get(0) >= K) break;
            if (list.size() == 1) return -1;
            
            mixed = list.get(0) + list.get(1)*2;
            if (mixed < K && list.size() == 2) return -1;
            list.remove(0);
            list.remove(0);
            list.add(mixed);
            answer++;
        }
        
        return answer;
    }
}