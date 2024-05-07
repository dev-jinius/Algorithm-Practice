class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int right = 0;	// 물류창고에서 배달 방향 상자 개수
        int left = 0;	// 배달 장소에서 물류창고 방향 상자 개수
        
        // 상자 개수가 양수인 경우 트럭이 한번만 지나가면 된다.
        // 상자 개수가 음수인 경우 트럭이 한번 더 와야 한다.
        // 거리 상 가장 먼 집부터 시작해서, 첫번 째 배달/수거는 무조건 와야하므로 음수로 시작한다.
        for (int i = n-1; i >= 0; i--) {
            int count = 0;
            right -= deliveries[i];
            left -= pickups[i];
            
            while (right < 0 || left < 0) {
                right += cap;
                left += cap;
                count += 1;
            }
            
            answer += (i+1)*2*count;
        }
        
        return answer;
    }
}