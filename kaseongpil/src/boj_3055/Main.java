package boj_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] forest;
    static Queue<int[]> waterQ = new ArrayDeque<>();
    static Queue<int[]> castorQ = new ArrayDeque<>();

    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    static int bfs() {
        int[][] dis = new int[R][C];

        while (!castorQ.isEmpty()) {
            int size = waterQ.size();
            for (int s = 0; s < size; s++) {
                var cur = waterQ.poll();
                int y = cur[0];
                int x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if (forest[ny][nx] != '.') continue;
                    forest[ny][nx] = '*';
                    waterQ.offer(new int[]{ny, nx});
                }
            }

            size = castorQ.size();
            for (int s = 0; s < size; s++) {
                var cur = castorQ.poll();
                int y = cur[0];
                int x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if (forest[ny][nx] == 'D') return dis[y][x] + 1;
                    if (forest[ny][nx] != '.') continue;
                    forest[ny][nx] = 'S';
                    dis[ny][nx] = dis[y][x] + 1;
                    castorQ.offer(new int[]{ny, nx});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        forest = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                forest[i][j] = s.charAt(j);
                if (forest[i][j] == '*') waterQ.offer(new int[]{i, j});
                else if (forest[i][j] == 'S') castorQ.offer(new int[]{i, j});
            }
        }

        int answer = bfs();
        System.out.print(answer == 0 ? "KAKTUS" : answer);

        br.close();
    }
}
