package boj_3190;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N; // 보드의 크기 - N * N
    static int K; // 사과의 개수
    static int L; // 뱀의 방향 전환 횟수

    static int[][] board; // 보드

    static Queue<Object> turn = new ArrayDeque<>();
    static Deque<int[]> snake = new ArrayDeque<>();

    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    static int snakeGame() {
        int time = 1;

        int turnTime = (int)turn.poll();
        char turnDir = (char)turn.poll();
        int dir = 0;

        while (true) {
            int[] head = snake.peek();

            int ny = head[0] + dy[dir];
            int nx = head[1] + dx[dir];

            if (ny < 1 || ny > N || nx < 1 || nx > N) break; // 뱀이 벽에 부딪침
            if (board[ny][nx] == 2) break; // 뱀이 몸에 부딪침
            if (board[ny][nx] == 0) { // 뱀이 간 곳에 사과는 없음
                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }
            snake.offerFirst(new int[]{ny, nx}); // 뱀이 이동한 곳에 사과가 있음
            board[ny][nx] = 2;

            if (!turn.isEmpty() && turnTime < time) {
                turnTime = (int)turn.poll();
                turnDir = (char)turn.poll();
            }
            if (turnTime == time) {
                if (turnDir == 'L')
                    dir = (dir + 3) % 4;
                else
                    dir = (dir + 1) % 4;
            }
            time++;
        }
        return time;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 6
        board = new int[N + 1][N + 1];
        board[1][1] = 2; // 뱀의 시작 위치
        snake.offer(new int[]{1, 1});

        K = Integer.parseInt(br.readLine()); // 3

        for (int i = 0; i < K; i++) {
            var st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            var st = new StringTokenizer(br.readLine());
            turn.offer(Integer.parseInt(st.nextToken()));
            turn.offer(st.nextToken().charAt(0));
        }

        bw.write(snakeGame() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
