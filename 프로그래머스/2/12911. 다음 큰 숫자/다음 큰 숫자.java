class Solution {
    static int count = 0;
    
    int counting(String binary) {
        int oneCount = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') oneCount++;
        }
        return oneCount;
    }
    
    public int solution(int n) {        
        String binary = Integer.toBinaryString(n);
        this.count = counting(binary);
        
        for (int i = n+1; ; i++) {
            String next = Integer.toBinaryString(i);
            if (counting(next) == count)
                return i;
        }
    }
}