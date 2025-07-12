package boj_2253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 0x7fffffff;
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 총 돌의 개수
        int M = Integer.parseInt(st.nextToken()); // 크기가 작은 돌의 개수

        boolean[] forbidden = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            forbidden[Integer.parseInt(br.readLine())] = true;
        }

        int maxJump = (int)Math.sqrt(2 * N) + 2;
        int[][] dp = new int[N + 1][maxJump + 1];

        for (int i = 0; i <= N; i++)
            Arrays.fill(dp[i], INF);

        dp[1][0] = 0;
        for (int i = 2; i <= N; i++) {
            if (forbidden[i]) continue;
            for (int j = 1; j <= maxJump; j++) {
                if (i - j >= 1) { // 이곳에 점프해 온 모든 경우 탐색
                    var jump = dp[i - j];
                    if (jump[j - 1] != INF) dp[i][j] = Math.min(dp[i][j], jump[j - 1] + 1);
                    if (jump[j] != INF) dp[i][j] = Math.min(dp[i][j], jump[j] + 1);
                    if (j + 1 <= maxJump && jump[j + 1] != INF) dp[i][j] = Math.min(dp[i][j], jump[j + 1] + 1);
                }
            }
        }

        int answer = INF;
        for (int i = 1; i <= maxJump; i++)
            answer = Math.min(answer, dp[N][i]);

        System.out.print(answer == INF ? -1 : answer);

        br.close();
    }
}
