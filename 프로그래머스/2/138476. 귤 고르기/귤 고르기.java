import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
            
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int current = map.getOrDefault(tangerine[i], 0);
            map.put(tangerine[i], current+1);
        }
        
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            list.add(map.get(key));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        int total = 0;
        int min = 0;
        for (int i : list) {
            if (total >= k) return min;
            total += i;
            min++;
        }
        
        return min;
    }
}