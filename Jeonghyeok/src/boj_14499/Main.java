package boj_14499;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[6];
    //동서남북
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            int cmd = Integer.parseInt(st.nextToken());
            move(cmd - 1);
        }
    }

    static void move(int dir) {
        int nx = x + dx[dir], ny = y + dy[dir];
        // 맵 밖이면 무시
        if (nx < 0 || nx >= N || ny < 0 || ny >= M) return;
        x = nx; y = ny;

        // 주사위 면 회전
        int top = dice[0], front = dice[1], right = dice[2], left = dice[3], back = dice[4], bottom = dice[5];
        switch (dir) {
            case 0: // 동
                dice[0] = left;
                dice[2] = top;
                dice[5] = right;
                dice[3] = bottom;
                break;
            case 1: // 서
                dice[0] = right;
                dice[3] = top;
                dice[5] = left;
                dice[2] = bottom;
                break;

            case 2: // 북
                dice[0] = front;
                dice[1] = bottom;
                dice[5] = back;
                dice[4] = top;
                break;
            case 3: // 남
                dice[0] = back;
                dice[4] = bottom;
                dice[5] = front;
                dice[1] = top;
                break;
        }

        if (map[x][y] == 0) {
            map[x][y] = dice[5];
        } else {
            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[0]);
    }
}
