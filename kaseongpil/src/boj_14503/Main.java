package boj_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, r, c, d;
    // N = 세로, M = 가로
    // r = 현재 행, c = 현재 열, d = 현재 방향
    static int[][] room;

    static final int[][] direction = {
            {-1, 0}, // north
            {0, 1},  // east
            {1, 0},  // south
            {0, -1}  // west
    };

    static int robotVacuum() {
        int answer = 0;
        while (true) {
            if (room[r][c] == 0) {
                room[r][c] = -1;
                answer++;
            }

            boolean dirty = false;
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;
                int nr = r + direction[d][0];
                int nc = c + direction[d][1];
                if (room[nr][nc] != 0) continue;
                r = nr; c = nc; // 청소가 안된 곳 발견 후 전진
                dirty = true;
                break;
            }

            if (!dirty) { // 발견 못할 시 후진
                int back = (d + 2) % 4;
                int br = r + direction[back][0];
                int bc = c + direction[back][1];

                if (room[br][bc] == 1) break;
                r = br; c = bc;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine()); // 방 크기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        room = new int[N][M];

        st = new StringTokenizer(br.readLine()); // 로봇 청소기 상태
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) { // 방 상태 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                room[i][j] = Integer.parseInt(st.nextToken());
        }

        int res = robotVacuum();

        System.out.print(res);

        br.close();
    }
}