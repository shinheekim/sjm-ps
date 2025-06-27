package boj_14499;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, x, y, K;
    static int[][] map;
    static int[] move;
    static final int[] dy = {0, 0, -1, 1};
    static final int[] dx = {1, -1, 0, 0};
    // 1 = east, 2 = west, 3 = north, 4 = south
    static int[] dice = new int[6];
    // 0 = top, 1 = east, 2 = west, 3 = north, 4 = south, 5 = bottom

    static void roll(int dir) {
        int temp;
        switch (dir) {
            case 1:
                temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
                break;
            case 2:
                temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 3:
                temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
                break;
            case 4:
                temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
                break;
        }
    }

    static int moving(int dir) {
        int ny = y + dy[dir - 1];
        int nx = x + dx[dir - 1];

        if (ny < 0 || nx < 0 || ny >= N || nx >= M) return -1;

        y = ny; x = nx;

        roll(dir);

        if (map[y][x] == 0) map[y][x] = dice[5];
        else {
            dice[5] = map[y][x];
            map[y][x] = 0;
        }
        return dice[0];
    }

    static int[] rollingDice() {
        var answer = new int[K];

        for (int i = 0; i < K; i++)
            answer[i] = moving(move[i]);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());

        // 지도의 크기는 N * M
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        // 주사위의 첫 위치
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        // 이동시킬 총 횟수
        K = Integer.parseInt(st.nextToken());
        move = new int[K];

        // 지도 입력
        for (int i = 0; i < N; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 이동 입력
        move = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        var res = rollingDice();

        for (var e : res)
            if (e != -1)
                bw.write(e + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
