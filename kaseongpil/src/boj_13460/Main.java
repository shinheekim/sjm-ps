package boj_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class State {
        int ry, rx, by, bx, depth;
        State(int ry, int rx, int by, int bx, int depth) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.depth = depth;
        }
    }
    static int N, M;
    static char[][] board;
    // . = 이동 가능
    // # = 이동 불가
    // O = 구멍
    // R = 빨간 구슬
    // B = 파란 구슬
    static Queue<State> q = new ArrayDeque<>();

    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    static int[] move(int y, int x, int dir) {
        int dist = 0;
        while (true) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if (board[ny][nx] == '#') break;
            if (board[ny][nx] == 'O') return new int[]{ny, nx, dist + 1, 1};
            y = ny;
            x = nx;
            dist++;
        }
        return new int[]{y, x, dist, 0};
    }

    static int bfs() {
        boolean[][][][] visited = new boolean[N][M][N][M];

        var start = q.peek();
        visited[start.ry][start.rx][start.by][start.bx] = true;

        while (!q.isEmpty()) {
            var cur = q.poll();
            if (cur.depth >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                var red = move(cur.ry, cur.rx, i);
                var blue = move(cur.by, cur.bx, i);

                if (blue[3] == 1) continue;
                if (red[3] == 1) return cur.depth + 1;

                if (red[0] == blue[0] && red[1] == blue[1]) {
                    if (red[2] > blue[2]) {
                        red[0] -= dy[i];
                        red[1] -= dx[i];
                    } else {
                        blue[0] -= dy[i];
                        blue[1] -= dx[i];
                    }
                }

                if (!visited[red[0]][red[1]][blue[0]][blue[1]]) {
                    visited[red[0]][red[1]][blue[0]][blue[1]] = true;
                    q.offer(new State(red[0], red[1], blue[0], blue[1], cur.depth + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        var bead = new State(0, 0, 0, 0, 0);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'B') {
                    bead.by = i;
                    bead.bx = j;
                }
                if (board[i][j] == 'R') {
                    bead.ry = i;
                    bead.rx = j;
                }
            }
        }

        q.offer(bead);

        System.out.print(bfs());

        br.close();
    }
}

