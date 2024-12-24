public class Solution {

    public int solution(int n) {
        if (n < 2) return 1;
        
        int count = 0;
        int num = n;
        int moc = 0;
        int flag = 0;
        
        while (true) {
            if (num == 2) return count+1;
            
            moc = num / 2;
            flag = num % 2;
            num = moc;
            
            if (moc == 1 && flag == 1) return count+2;
            
            if (flag == 1) 
                count++;
        }
    }
}