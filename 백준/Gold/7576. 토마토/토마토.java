import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<int[]> queue;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int m;
    static int n;
    static int[][] box;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        queue = new LinkedList<>();
        box = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = scanner.nextInt();
                if (box[i][j] == 1)
                    queue.offer(new int[] {i, j});
            }
        }

        bfs();

        int day = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                day = Math.max(box[i][j], day);
            }
        }
        System.out.println(day-1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            int x = tomato[1];
            int y = tomato[0];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (box[ny][nx] == 0) {
                        box[ny][nx] = box[y][x] + 1;
                        queue.offer(new int[] {ny, nx});
                    }
                }
            }
        }
    }
}