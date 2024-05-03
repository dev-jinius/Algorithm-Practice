class Solution {
    public int solution(int n) {
        int answer = 0;
        if (n == 0 || n == 1) return answer += n;
        
        answer = 1 + n;
        int value = -1;
        for (int i = 2; i < n; i++) {
            if (value == i) break;
            if (n % i == 0) {
                value = n / i;
            
            	if (value == i) {
            	    answer += value;
            		break;
            	} else {
            		answer = answer + i + value;
            	}
            }
        }
        
        return answer;
    }
}