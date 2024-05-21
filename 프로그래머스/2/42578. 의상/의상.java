import java.util.*;

/*
	1. 의상 종류 별 아이템 개수를 카운트한다.
	2. 아이템 개수로 의상 조합 경우의 수를 계산한다.
*/
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.compute(clothes[i][1], (key, value) -> value + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }
        
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        answer -= 1;
        
        return answer;
    }
}