class Solution {
    int count;
    int target;
    int[] numbers;
    int len;
    
    public void dfs(int idx, int sum) {
        if (idx == len) {
        	if (sum == target) count++;
            return;
        }
        
        dfs(idx+1, sum + numbers[idx]);
        dfs(idx+1, sum - numbers[idx]); 
    }
    
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        this.count = 0;
        this.len = numbers.length;
        
        dfs(0, 0);
        
        return count;
    }
}