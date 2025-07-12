package boj_1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] memo;
    static int dp(int n) {
        if (n == 1 || n == 2) return n;
        if (memo[n] != 0) return memo[n];
        return memo[n] = (dp(n - 1) + dp(n - 2)) % 15746;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new int[n + 1];

        System.out.print(dp(n));

        br.close();
    }
}
