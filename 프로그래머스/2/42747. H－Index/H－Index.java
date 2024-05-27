import java.util.*;

class Solution {
    public int solution(int[] citations) {

        int answer = 0;
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
            //인용된 논문 개수
            int h = citations.length - i;
            
            if (citations[i] >= h) {
                //answer = h;
                //break;
                return h;
            }
        }
        
        return 0;
        //return answer;
    }
}