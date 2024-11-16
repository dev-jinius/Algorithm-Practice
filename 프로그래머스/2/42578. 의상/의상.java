import java.util.*;

/*
	1. 의상 종류 별 아이템 개수를 카운트한다.
	2. 아이템 개수로 의상 조합 경우의 수를 계산한다.
*/
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        //의상 수 카운팅
        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0)+1);
        }
        
        for (String key : map.keySet()) {
        	//키에 해당하는 의상 수 + 입지 않은 경우(+1)
            answer *= map.get(key)+1;
        }
        answer -= 1;
        
        return answer;
    }
}