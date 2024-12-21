import java.util.*;

class Solution {
    static int len;
    static int[][] dungeons;
    static int maxCount;
    
    static void dfs(int hp, int count, boolean[] visited) {
        maxCount = Math.max(maxCount, count);
        
        for (int i = 0; i < len; i++) {
            if (!visited[i] && hp >= dungeons[i][0]) {
                visited[i] = true; // 방문 처리
                dfs(hp-dungeons[i][1], count+1, visited); // 탐험 후 재귀 호출
                visited[i] = false; // 복구(백트래킹)
            }
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        this.len = dungeons.length;
        this.maxCount = 0;
        
        boolean[] visited = new boolean[len];
        dfs(k, 0, visited);
        
        return maxCount;
    }
}