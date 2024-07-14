import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int n = board[0].length;
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < n; j++) {
                int target = board[j][moves[i]-1];
                System.out.println("target = " + target);
            	if (target != 0) {
                    if(!stack.isEmpty() && stack.peek() == target) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(target);
                    }
                    board[j][moves[i]-1] = 0;                   
                    break;
                }
            }
        }
        
        return answer;
    }
}