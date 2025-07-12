 package boj_2606;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

        dfs(1);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (visited[i]) count++;
        }
        System.out.println(count -1 );
    }

    static void dfs(int v) {
        visited[v] = true;
        for (int i = 1; i <= N; i++) {
            if (adj[v][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}