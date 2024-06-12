import java.util.*;

class Solution {
	//1번 노드와 가장 멀리 떨어진 노드는?
    boolean[] visit;		// 해당 노드(배열 인덱스)에 이미 방문했는지 여부
    boolean[][] relative;	// 인접 행렬 (그래프 관계)
    
    public int bfs(int[][] edge) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visit[1] = true;
        
        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            
            relative[x][y] = true;
            relative[y][x] = true;
        }
		
        int size = 0;
        while (!que.isEmpty()) {
            size = que.size();
            
            for (int i = 0; i < size; i++) {
                int current = que.poll();
                
                for (int j = 1; j < visit.length; j++) {
                    if (!visit[j] && relative[current][j]) {
                        que.add(j);
                        visit[j] = true;
                    }
                }
            }
        }
        return size;
    }
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        this.visit = new boolean[n+1];
        this.relative = new boolean[n+1][n+1];
        
        answer = bfs(edge);
        
        return answer;
    }
}