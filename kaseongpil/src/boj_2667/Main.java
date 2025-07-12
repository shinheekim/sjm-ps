package boj_2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N;
    static int[][] apartment;
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    static int dfs(int y, int x) {
        apartment[y][x] = 0;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (apartment[ny][nx] == 0) continue;
            area += dfs(ny, nx);
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));
        var list = new ArrayList<Integer>();

        N = Integer.parseInt(br.readLine());
        apartment = new int[N][N];

        for (int i = 0; i < N; i++) {
            var s = br.readLine();
            for (int j = 0; j < N; j++)
                apartment[i][j] = Character.getNumericValue(s.charAt(j));
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apartment[i][j] == 1) {
                    cnt++;
                    list.add(dfs(i, j));
                }
            }
        }
        Collections.sort(list);

        bw.write(cnt + "\n");
        for (var e : list)
            bw.write(e + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
