package boj_10157;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[][] seat;
    private static int C, R;

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static String check(int k) {
        // 0 -> left, 1 -> right, 2 -> down, 3 -> up
        int direction = 0;
        int x = 1, y = 1;
        int count = 1;

        if (C * R < k)
            return "0";

        while (count <= C * R) {
            seat[y][x] = count++;
            // early return
            if (count - 1 == k)
                return x + " " + y;

            int ny = y + dy[direction];
            int nx = x + dx[direction];

            if (ny < 1 || ny > R || nx < 1 || nx > C || seat[ny][nx] != 0) {
                direction = (direction + 1) % 4;
                count--;
            }
            else {
                y = ny;
                x = nx;
            }
        }
        return C + " " + R;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        seat = new int[R + 1][C + 1];

        bw.write(check(K));

        bw.flush();
        bw.close();


        br.close();

        // 조치를 취해야 할 경우
        // 1. K가 C * R보다 클 경우
        // 2. 이미 좌석을 구한 경우
        // 3. 현재 위치가 배열의 크기를 벗어 났을 때
    }
}
