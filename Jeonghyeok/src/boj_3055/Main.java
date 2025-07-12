package boj_3055;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        ArrayDeque<int[]> waterQ = new ArrayDeque<>();
        ArrayDeque<int[]> beaverQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '*') waterQ.offer(new int[]{i, j});
                else if (map[i][j] == 'S') {
                    beaverQ.offer(new int[]{i, j});
                    visited[i][j] = true;
                    map[i][j] = '.';
                }
            }
        }

        int time = 0;
        while (!beaverQ.isEmpty()) {
            time++;

            // 물 확장
            int waterSize = waterQ.size();
            for (int w = 0; w < waterSize; w++) {
                int[] wpos = waterQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = wpos[0] + dx[d], ny = wpos[1] + dy[d];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQ.offer(new int[]{nx, ny});
                    }
                }
            }

            // 이동
            int beaverSize = beaverQ.size();
            for (int b = 0; b < beaverSize; b++) {
                int[] pos = beaverQ.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = pos[0] + dx[d], ny = pos[1] + dy[d];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (visited[nx][ny] || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
                    if (map[nx][ny] == 'D') {
                        System.out.println(time);
                        return;
                    }
                    visited[nx][ny] = true;
                    beaverQ.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println("KAKTUS");
    }
}