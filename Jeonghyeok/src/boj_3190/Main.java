package boj_3190;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> turns = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            turns.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dir = 0, time = 0;
        Deque<int[]> snake = new ArrayDeque<>();
        boolean[][] occupied = new boolean[N][N];

        snake.offerLast(new int[]{0, 0});
        occupied[0][0] = true;

        while (true) {
            time++;
            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir], ny = head[1] + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || occupied[nx][ny]) {
                System.out.println(time);
                return;
            }

            snake.offerLast(new int[]{nx, ny});
            occupied[nx][ny] = true;

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0;
            } else {
                int[] tail = snake.pollFirst();
                occupied[tail[0]][tail[1]] = false;
            }

            if (turns.containsKey(time)) {
                char t = turns.get(time);
                dir = (t == 'L' ? (dir + 3) % 4 : (dir + 1) % 4);
            }
        }
    }
}