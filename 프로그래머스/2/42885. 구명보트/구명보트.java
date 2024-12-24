import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int count = 0;
        
        Arrays.sort(people);
        
        int last = people.length-1;
        int first = 0;
        while (first <= last) {
            if (people[last] + people[first] <= limit) first++;
            count++;
            last--;
        }
        
        return count;
    }
}