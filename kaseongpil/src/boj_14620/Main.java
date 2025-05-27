package boj_14620;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int res = 0x7FFF_FFFF;

    static int[] dy = {0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                 map[i][j] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(res);
    }

    static void dfs(int depth, int cost) {
        if (depth == 3) {
            res = Math.min(res, cost);
            return;
        }

        for (int i = 1; i < N - 1; i++)
            for (int j = 1; j < N - 1; j++) {
                if (canBloom(i, j)) {
                    dfs(depth + 1, cost + plant(i, j, true));
                    plant(i, j, false);
                }
            }
    }

    static boolean canBloom(int y, int x) {
        for (int d = 0; d < 5; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (visited[ny][nx]) return false;
        }
        return true;
    }

    static int plant(int y, int x, boolean flag) {
        int total = 0;
        for (int d = 0; d < 5; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            visited[ny][nx] = flag;
            total += map[ny][nx];
        }
        return total;
    }
}
