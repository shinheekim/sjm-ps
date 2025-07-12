package boj_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int depth, int cur) {
        if (depth == M) {
            for (int i = 0; i < M; i++)
                sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            answer[depth] = i;
            if (cur > i) continue;
            bfs(depth + 1, i);
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];

        bfs(0, 1);

        System.out.print(sb);

        br.close();
    }
}
