import java.util.*;

class Solution {
    static int[][] computers;
    static int network;
    static boolean[] visited;
    
    void dfs(int no, boolean[] visited) {
        visited[no] = true;
        
        for (int i = 0; i < computers[no].length; i++) {
            if (!visited[i] && i != no && computers[no][i] == 1)
                dfs(i, visited);
        }
        
        return;
    }
        
    public int solution(int n, int[][] computers) {
        this.computers = computers;
        this.network = 0;
        this.visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                network++;
                dfs(i, visited);
            }
        }
        
        return network;
    }
}