package boj_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N + 1];
        int[] dp;

        for (int i = 1; i <= N; i++)
            stair[i] = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[1] = stair[1];
        if (N > 1) {
            dp[2] = stair[1] + stair[2];

            for (int i = 3; i <= N; i++)
                dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);
        }
        System.out.print(dp[N]);

        br.close();
    }
}
