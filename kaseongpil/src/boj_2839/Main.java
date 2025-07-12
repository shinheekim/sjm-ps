package boj_2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 3];
        Arrays.fill(dp, INF);

        dp[3] = 1;
        dp[5] = 1;

        for (int i = 3; i <= N; i++)
            for (var e : new int[]{3, 5})
                if (i - e >= 0) dp[i] = Math.min(dp[i], dp[i - e] + 1);

        System.out.print(dp[N] == INF ? -1 : dp[N]);

        br.close();
    }
}
