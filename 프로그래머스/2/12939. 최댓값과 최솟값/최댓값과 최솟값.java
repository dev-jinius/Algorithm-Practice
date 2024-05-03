class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] str = s.split(" ");
        int min = Integer.parseInt(str[0]);
        int max = Integer.parseInt(str[0]);
        int valInt = 0;
        for (String val : str) {
            valInt = Integer.parseInt(val);
            if (valInt < min) {
                min = valInt;
            } else if (valInt > max) {
                max = valInt;
            }
        }
        
        answer = min + " " + max; 
        
        return answer;
    }
}