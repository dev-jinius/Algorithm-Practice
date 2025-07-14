import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private final static int MAX = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);   // 수빈
        int k = Integer.parseInt(input[1]);   // 동생
        int sec = bfs(n, k);
        System.out.println(sec);
    }

    public static int bfs (int start, int end) {
        int[] dist = new int[MAX];
        boolean[] visited = new boolean[MAX];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == end) {
                return dist[cur];
            }

            for (int next : new int[] {cur-1, cur+1, cur*2}) {
                if (next >= 0 && next < MAX && !visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
        }
        return -1;
    }
}