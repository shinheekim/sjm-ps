 package boj_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {1,-1 , 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<int[]> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        bfs();

        System.out.println(visited[n - 1][m - 1]);

    }
    static void bfs() {

        q.add(new int[]{0,0});
        visited[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if(map[nx][ny] == 0 || visited[nx][ny] != 0) {
                    continue;
                }
                visited[nx][ny] = visited[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }
    }
}

