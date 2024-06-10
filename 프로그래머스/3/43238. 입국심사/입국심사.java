import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        int len = times.length;
        
        Arrays.sort(times);
        long min = 0L;
		long max = times[len-1] * (long)n;       
        
        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0L;
            for (int i = 0; i < len; i++) {
                count += mid / times[i];
            }
            if (count < n)
                min = mid + 1;
            else {
                max = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}