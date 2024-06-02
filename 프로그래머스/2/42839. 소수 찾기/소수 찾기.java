class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        int result = check(20);
        System.out.println(result);
        
        return answer;
    }
    
    //소수 체크(소수이면 1, 소수가 아니면 0 return)
    public int check(int num) {
        if (num < 2) return 0;
        for (int i = 2; i*i <= num; i++) {
            if (num % i == 0) return 0;
        }
        return 1;
    }
}