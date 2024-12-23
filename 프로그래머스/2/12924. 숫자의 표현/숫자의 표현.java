import java.util.*;

class Solution {
    static int count = 0;
    static int goal = 0;
    
    boolean isPossible(int start) {
        int sum = 0;
        for (int i = start; i <= goal; i++) {
            sum += i;
            if (sum == goal) return true;
            if (sum > goal) return false;
        }
        return false;
    }
    
    public int solution(int n) {
        int answer = 0;
        this.goal = n;
        
        for (int i = 1; i <= n; i++) {
            if (isPossible(i)) {
                count++;
            }
        }
        
        return count;
    }
}