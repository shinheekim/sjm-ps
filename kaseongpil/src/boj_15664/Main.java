package boj_15664;

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

    static void bfs(int depth, int pre) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (visited[i] || sequence[pre] > sequence[i]) continue;
            if (i > 0 && sequence[i] == sequence[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            answer[depth] = sequence[i];
            bfs(depth + 1, i);
            visited[i] = false;
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
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sequence);

        bfs(0, 0);

        System.out.print(sb);

        br.close();
    }
}
