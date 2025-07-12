package boj_2178;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] maze;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    public static class Triple<First, Second, Third> {
        private final First first;
        private final Second second;
        private final Third third;
        Triple(First first, Second second, Third third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        First getFirst() {
            return first;
        }
        
        Second getSecond() {
            return second;
        }

        Third getThird() {
            return third;
        }
    }

    static int bfs(int y, int x) {
        Queue<Triple<Integer, Integer, Integer>> q = new ArrayDeque<>();
        
        q.offer(new Triple<>(y, x, 1));
        maze[y][x] = '2';

        while (!q.isEmpty()) {
            var point = q.poll();
            int curY = point.getFirst();
            int curX = point.getSecond();
            int distance = point.getThird();
            if (curY == N - 1 && curX == M - 1) return distance;
            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M || maze[ny][nx] != '1') continue;
                maze[ny][nx] = '2';
                q.offer(new Triple<>(ny, nx, distance + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        maze = new char[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        bw.write(bfs(0, 0) + "");
        
        br.close();
        bw.flush();
        bw.close();
    }
}
