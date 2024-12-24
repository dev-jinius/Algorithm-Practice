import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {        
        Set<String> record = new HashSet<>();
        
        int count = 1;
        char prev = ' ';

        for (int i = 0; i < words.length; i++) {
            if ((i > 0 && words[i].charAt(0) != prev) || record.contains(words[i]))
                return new int[] {(i+1) % n == 0 ? n : (i+1) % n, count};
            
            prev = words[i].charAt(words[i].length()-1);
            
            record.add(words[i]);
            if ((i+1) % n == 0) count++;
        }

        return new int[] {0,0};
    }
}