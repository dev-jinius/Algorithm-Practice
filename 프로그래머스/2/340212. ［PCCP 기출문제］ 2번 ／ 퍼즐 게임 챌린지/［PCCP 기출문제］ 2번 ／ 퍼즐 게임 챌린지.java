import java.util.Arrays;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        int min = 1;
        int max = Arrays.stream(diffs).max().getAsInt();
        
        System.out.println(min);
        System.out.println(max);
        
        while (min <= max) {
            int level = (min+max)/2;
            System.out.println("answer : " + answer);
            System.out.println("level : " + level);
            System.out.println("min : " + min + " , max : " + max);

            int total = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {
                    total += times[i];
                    continue;
                }
                total += i == 0 ? times[i] : (times[i-1] + times[i])*(diffs[i]-level) + times[i];
            }
            
            if ((long)total >= limit) {
                min = level+1;
                continue;
            }
            
            answer = Math.min(level, max);
            max = level-1;
        }
        
        return answer;
    }
}