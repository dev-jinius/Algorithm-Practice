import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {1, -1, 0, 0}; 		// 동서남북 방향 벡터
        int[] dy = {0, 0, 1, -1}; 		// 동서남북 방향 벡터
        int xMax = maps[0].length - 1; 	// x 좌표의 최대값
        int yMax = maps.length - 1; 	// y 좌표의 최대값
        
        boolean[][] visit = new boolean[yMax + 1][xMax + 1]; // 방문 체크 배열
        Queue<int[]> queue = new LinkedList<>(); // BFS를 위한 큐
        queue.add(new int[] {0, 0, 1}); // 시작점 (0, 0)과 시작 거리 1을 큐에 추가
        visit[0][0] = true; // 시작점 방문 체크
        
        while (!queue.isEmpty()) { 			// 큐가 비어있지 않으면 반복
            int[] current = queue.poll(); 	// 큐에서 현재 노드를 꺼냄
            int x = current[0]; 			// 현재 x 좌표
            int y = current[1]; 			// 현재 y 좌표
            int dist = current[2]; 			// 현재까지의 거리
            
            if (x == xMax && y == yMax) { 	// 목표 지점에 도달하면
                return dist; 				// 현재까지의 거리를 반환
            }
            
            for (int i = 0; i < 4; i++) { 	// 동서남북 네 방향으로 탐색
                int nx = x + dx[i]; 		// 새로운 x 좌표
                int ny = y + dy[i]; 		// 새로운 y 좌표
                
                // 탐색 종료 조건(맵 벗어남, 벽, 재방문)
                if (nx < 0 || ny < 0 || nx > xMax || ny > yMax) continue;
                if (maps[ny][nx] == 0) continue;
                if (visit[ny][nx]) continue;
                
                visit[ny][nx] = true;					// 방문 체크
                queue.add(new int[] {nx, ny, dist+1}); 	// 현재 좌표 큐에 추가
            }
        }
        
        return -1; // 큐를 다 돌고 목표 지점에 도달할 수 없는 경우
    }
}