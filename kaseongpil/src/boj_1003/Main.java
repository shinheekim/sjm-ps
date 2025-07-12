package boj_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] memo = new int[41][2];

    static void fibonacci(int n) {
        if (n == 0) {
            memo[0][0] = 1;
            memo[0][1] = 0;
        } else if (n == 1) {
            memo[1][0] = 0;
            memo[1][1] = 1;
        } else if (memo[n][0] == 0 && memo[n][1] == 0) {
            fibonacci(n - 2);
            fibonacci(n - 1);
            memo[n][0] = memo[n - 2][0] + memo[n - 1][0];
            memo[n][1] = memo[n - 2][1] + memo[n - 1][1];
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        fibonacci(40);

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(memo[N][0] + " " + memo[N][1]);
        }

        br.close();
    }
}
