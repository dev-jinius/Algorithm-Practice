import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalCount = brown + yellow;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 3; i*i<= totalCount; i++) {
            if (totalCount % i == 0) {
				numMap.put(i, totalCount/i);                
            }
        }
        
        for (int n : numMap.keySet()) {
            int sero = n;
            int garo = numMap.get(n);
            if (garo * 2 >= brown) continue;
            else {
                if((brown-garo*2) % (sero-2) == 0 || yellow % sero == 0) {
                    answer[0] = garo;
                    answer[1] = sero;
                    break;
                } else continue;
            }
        }
        
        return answer;
    }
}