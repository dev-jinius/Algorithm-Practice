import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
		
        int max = 0;
        int count = 0;
        int deploy = 0;
       	List<Integer> counts = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            deploy = (100-progresses[i])%speeds[i]==0 ? (100-progresses[i])/speeds[i] : (100-progresses[i])/speeds[i] + 1;  
            if (max == 0) {
                max = deploy;
            } 
            
            if (deploy <= max) {
                count += 1;
            } else {
                counts.add(count);  
                max = deploy;
                count = 1;
            }
            
            if (i == progresses.length - 1) {
                counts.add(count);
                break;
            }
        }
        
        answer = counts.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}