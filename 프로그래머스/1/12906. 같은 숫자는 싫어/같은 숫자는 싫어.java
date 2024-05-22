import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
       
        List<Integer> list = new ArrayList<>();
        
        int num = arr[0];
        for (int n : arr) {
            if (n != num) {
        		list.add(num);
                num = n;
            }
        }
        list.add(arr[arr.length-1]);
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}