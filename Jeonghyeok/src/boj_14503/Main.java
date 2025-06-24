 package boj_14503;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] room; // 방 상태: 0= 가능, 1=벽, 2= 완료
    static int r, c, d; // 로봇 위치 및 방향

    // 방향: 북(0), 동(1), 남(2), 서(3)
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        // 입력 3: 방 상태
        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cleanedCount = simulate();
        System.out.println(cleanedCount);
    }

    static int simulate() {
        int count = 0;

        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = 2;
                count++;
            }

            boolean cleaned = false;


            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 방향으로 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    cleaned = true;
                    break;
                }
            }

            if (cleaned) continue;

            int back = (d + 2) % 4;
            int bx = r + dx[back];
            int by = c + dy[back];

            if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1) {
                r = bx;
                c = by;
            } else {
                break;
            }
        }

        return count;
    }
}