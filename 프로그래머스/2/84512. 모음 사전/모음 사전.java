import java.util.*;

class Solution {
    static Map<String, Integer> dic;    //모음사전(단어, 번호)
    static String[] words = {"A", "E", "I", "O", "U"};
    static int count = 0;
    
    static void makeDic(String str, int depth) {
        dic.put(str, count);
        count++;

        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            makeDic(str+words[i], depth+1);
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        dic = new HashMap<>();
        
        //DFS로 사전만들기
        makeDic("", 0);
                
        return dic.get(word);
    }
}