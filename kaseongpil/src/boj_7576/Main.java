package boj_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] tomato;
    static Queue<int[]> q = new ArrayDeque<>();
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};


    static void bfs() {
        while (!q.isEmpty()) {
            var cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (tomato[ny][nx] != 0) continue;
                tomato[ny][nx] = tomato[y][x] + 1;
                q.offer(new int[]{ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) q.offer(new int[]{i, j});
            }
        }

        bfs();

        int max = 0;
        for (var e : tomato)
            for (var d : e) {
                if (d == 0) {
                    System.out.print(-1);
                    System.exit(0);
                }
                else max = Math.max(max, d - 1);
            }

        System.out.print(max);

        br.close();
    }
}
