package boj_9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] coins;
    static int[][] memo;

    static int dp(int idx, int sum) {
        if (sum == M) return 1;
        if (sum > M) return 0;
        if (idx == N) return 0;
        if (memo[idx][sum] != -1) return memo[idx][sum];

        int use = dp(idx, sum + coins[idx]);
        int skip = dp(idx + 1, sum);
        return memo[idx][sum] = use + skip;
    }

//    static int dp() {
//        int[] memo = new int[M + 1];
//        memo[0] = 1;
//        for (var coin : coins) {
//            for (int i = coin; i <= M; i++)
//                memo[i] += memo[i - coin];
//        }
//        return memo[m];
//    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            coins = new int[N];
            var st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                coins[i] = Integer.parseInt(st.nextToken());

            M = Integer.parseInt(br.readLine());

//            memo = new int[M + 1];
//            sb.append(dp()).append("\n");

            memo = new int[N][M + 1];
            for (int i = 0; i < N; i++)
                for (int j = 0; j <= M; j++)
                    memo[i][j] = -1;
            sb.append(dp(0, 0)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
