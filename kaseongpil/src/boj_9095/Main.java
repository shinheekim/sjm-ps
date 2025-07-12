package boj_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12];

        dp[0] = 1;

        for (int i = 0; i <= 11; i++) {
            for (var e : new int[]{1, 2, 3}) {
                if (e + i <= 11) dp[e + i] += dp[i];
            }
        }

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

        br.close();
    }
}
