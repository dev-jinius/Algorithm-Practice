import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int min = 1;
        int max = Arrays.stream(diffs).max().getAsInt();
        answer = max;
        
        while (min <= max) {
            int level = (min+max)/2;
            long total = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {
                    total += times[i];
                } else {
                    total += (long) (times[i-1] + times[i]) * (diffs[i] - level) + times[i]; 
                }

                // 제한 시간을 초과하면 중단
                if (total > limit) {
                    break;
                }
            }
            
            if (total <= limit) {
                answer = Math.min(answer, level);
                max = --level;
            } else {
                min = ++level;
            }
        }
        
        return answer;
    }
}