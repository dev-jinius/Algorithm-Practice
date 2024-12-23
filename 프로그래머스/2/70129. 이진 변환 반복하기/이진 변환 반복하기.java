class Solution {
    static int change = 0;
    static int count = 0;
    
    void toBinary(String str, int depth) {
        if (str.equals("1")) {
            change = depth;
            return;
        }
        
        String current = str;
        current = current.replaceAll("0", "");  //0 제거
        count += str.length()-current.length(); //제거된 0 개수 더하기
        
        current = Integer.toBinaryString(current.length()); //이진 변환        
        toBinary(current, depth+1);
    }
    public int[] solution(String s) {
        
        toBinary(s, 0);

        return new int[]{change, count};
    }
}