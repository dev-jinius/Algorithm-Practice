import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
//         yellow = 2 -> 1x2
//         yellow = 1 -> 1x1
//         yellow = 24 -> 1x24 2x12 3x8 4x6
        
//         brown = (24+2)*(1+2) = 26 x 3 = 78-24=54
//         brown = (12+2)x(2+2) = 14 x 4 = 56-24=32
//         brwon = (8+2)x(3+2) = 10 x 5 = 50-24=26
//         brwon = (6+2)x(4+2) = 48-24=24
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i*i <= yellow; i++) {
            if (yellow%i == 0)
                list.add(i);
        }
        
        for (int y : list) {
            if (brown == ((y+2)*(yellow/y+2)-yellow)) {
                answer[0] = Math.max(y, yellow/y)+2;
                answer[1] = (brown+yellow)/answer[0];
            }
        }    
            
        return answer;
    }
}