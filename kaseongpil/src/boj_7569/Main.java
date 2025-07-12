package boj_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H;
    // M = 상자의 가로
    // N = 상자의 세로
    // H = 상자의 개수
    static int[][][] tomato;
    static Queue<int[]> q = new ArrayDeque<>();

    static final int[] dz = {1, -1, 0, 0, 0, 0};
    static final int[] dy = {0, 0, 1, -1, 0, 0};
    static final int[] dx = {0, 0, 0, 0, 1, -1};

    static void bfs() {
        while (!q.isEmpty()) {
            var cur = q.poll();
            int z = cur[0];
            int y = cur[1];
            int x = cur[2];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (nz < 0 || nz >= H ||         // 상자의 높이
                    ny < 0 || ny >= N ||         // 상자의 세로
                    nx < 0 || nx >= M) continue; // 상자의 가로
                if (tomato[nz][ny][nx] != 0) continue; // 토마토를 익게 할 수 없는 경우(이미 익었거나, 없을 경우)
                tomato[nz][ny][nx] = tomato[z][y][x] + 1;
                q.offer(new int[]{nz, ny, nx});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];

        for (int h = 0; h < H; h++)
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    tomato[h][i][j] = Integer.parseInt(st.nextToken());
                    if (tomato[h][i][j] == 1) q.offer(new int[]{h, i, j});
                }
            }

        bfs();

        int max = 0;
        for (var z : tomato)
            for (var y : z)
                for (var x : y) {
                    if (x == 0) {
                        System.out.print(-1);
                        System.exit(0);
                    }
                    max = Math.max(max, x - 1);
                }

        System.out.print(max);

        br.close();
    }
}
