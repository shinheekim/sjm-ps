package boj_1260;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, V;
    static boolean[][] graph;

    static void dfs(int node, boolean[] visited) throws Exception {
        if (visited[node]) return;
        visited[node] = true;
        bw.write(node + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[node][i]) dfs(i, visited);
        }
    }

    static void bfs(int node, boolean[] visited) throws Exception {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
         while (!q.isEmpty()) {
            node = q.poll();
            if (!visited[node]) {
                bw.write(node + " ");
                visited[node] = true;
                for (int i = 1; i <= N; i++) {
                    if (graph[node][i]) q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int link = Integer.parseInt(st.nextToken());
            graph[node][link] = true;
            graph[link][node] = true; // graph는 양방향임
        }

        dfs(V, new boolean[N + 1]); // 시작은 V
        bw.write("\n");
        bfs(V, new boolean[N + 1]);
        br.close();
        bw.flush();
        bw.close();
    }
}
