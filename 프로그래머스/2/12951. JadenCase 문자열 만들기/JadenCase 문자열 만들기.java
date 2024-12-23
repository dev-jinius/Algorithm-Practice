import java.util.*;

class Solution {
    public String solution(String s) {
        String result = "";
        int space = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i, i+1);
            if (str.equals(" ")) {
                result += str;
                space++;
            } else {
                if (i == 0) {
                    result += str.toUpperCase();
                    continue;
                }
            
                if (space > 0) {
                    if (!str.equals(" ")) {
                        result += str.toUpperCase();
                        space = 0;
                    } else {
                        result += " ";
                        space++;
                    }
                } else {
                    result += str.toLowerCase();
                }
            }
        }    
            
        return result;
    }
}