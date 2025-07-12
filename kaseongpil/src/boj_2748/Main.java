package boj_2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] memo;

//    top-down
//    static long fibonacci(int level) {
//        if (level < 0) return 0;
//        if (level == 1 || level == 2) return 1;
//        if (memo[level] != 0) return memo[level];
//
//        memo[level] = fibonacci(level - 1) + fibonacci(level - 2);
//
//        return memo[level];
//    }
//
//    public static void main(String[] args) throws IOException {
//        var br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        memo = new long[n + 1];
//
//        System.out.print(fibonacci(n));
//
//        br.close();
//    }

//    bottom-up
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        memo = new long[n + 1];

        if (n < 2) answer = 1;
        else {
            memo[1] = 1;
            memo[2] = 1;
            for (int i = 3; i <= n; i++)
                memo[i] = memo[i - 1] + memo[i - 2];
            answer = memo[n];
        }

        System.out.print(answer);

        br.close();
    }
}
