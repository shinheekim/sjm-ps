package boj_15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] sequence;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = sequence[i];
                bfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        sequence = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sequence);

        bfs(0);

        System.out.print(sb);

        br.close();
    }
}
