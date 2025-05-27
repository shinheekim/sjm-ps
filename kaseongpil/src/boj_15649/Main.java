package boj_15649;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br. readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];
        answer = new int[N];

        dfs(0);

        System.out.println(sb);
    }

    static public void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++)
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }

    }
}
