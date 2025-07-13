import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int cnt = 1;
        
        int row = maps.length;
        int col = maps[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] visited = new boolean[row][col];
        int[][] dist = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] player = queue.poll();
            int cx = player[0];
            int cy = player[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return dist[row-1][col-1] <= 1 ? -1 : dist[row-1][col-1];
    }
}