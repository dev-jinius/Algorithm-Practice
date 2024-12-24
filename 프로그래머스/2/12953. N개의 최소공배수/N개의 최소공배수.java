class Solution {
    static int[] arr;
    static int len;
    
    static int gcd(int b, int s) {
        if (b % s == 0) return s;
        
        return gcd(s, b%s);
    }
    
    static int lcm(int b, int s) {
        int gcd = gcd(b, s);
        return b * s / gcd;
    }
    
    static int solve() {
        int prev = lcm(Math.max(arr[0], arr[1]), Math.min(arr[0], arr[1]));
        
        if (len == 2) return prev;
        
        for (int i = 2; i < len; i++) {
            prev = lcm(Math.max(prev, arr[i]), Math.min(prev, arr[i]));
        }
        
        return prev;
    }
    
    public int solution(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
        
        if (len == 1) return arr[0];
        int result = solve();
        return result;
    }
}