package boj_1139;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    private static int dfs(int row, int column, int depth) {
        if (row == 0 && column == C - 1)
            return depth == K ? 1 : 0;
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int ny = row + dy[i];
            int nx = column + dx[i];

            if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
            if (map[ny][nx] == 'T' || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            res += dfs(ny, nx, depth + 1);
            visited[ny][nx] = false;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++)
            map[i] = br.readLine().toCharArray();

        visited[R - 1][0] = true;
        System.out.println(dfs(R - 1, 0, 1));
    }
}
