import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (String item : str)
            list.add(Integer.parseInt(item));
        
        Collections.sort(list);
        
        answer = list.get(0) + " " + list.get(list.size()-1);
        
        return answer;
    }
}