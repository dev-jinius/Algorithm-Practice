import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalCount = brown + yellow;
        Map<Integer, Integer> numMap = new HashMap<>();
        // 전체 개수의 약수 구함.
        // 전체 개수의 3 ~ 제곱근까지 반복 => 제곱근 이후에는 가로와 세로 값이 반전되기 때문.
        for (int i = 3; i*i<= totalCount; i++) {
            if (totalCount % i == 0) {
				numMap.put(i, totalCount/i);                
            }
        }
        
        for (int n : numMap.keySet()) {
            //가로 길이가 세로 길이보다 같거나 길다 조건 => 세로가 더 짧다. key 순서대로 돌아가므로 키는 세로. 값은 가로다.
            int sero = n;
            int garo = numMap.get(n);
            if (garo * 2 >= brown) continue;
            else {
                if ((garo - 2) * (sero - 2) == yellow) {
                //if((brown-garo*2) % (sero-2) == 0 || yellow % sero == 0) {
                    answer[0] = garo;
                    answer[1] = sero;
                    break;
                } else continue;
            }
        }
        
        return answer;
    }
}