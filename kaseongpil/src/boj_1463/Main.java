package boj_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N + 3];
        memo[2] = 1;
        memo[3] = 1;

        for (int i = 4; i <= N; i++) {
            int a = 0x7fffffff;
            int b = a;
            int c = b;
            if (i % 3 == 0) a = memo[i / 3] + 1;
            if (i % 2 == 0) b = memo[i / 2] + 1;
            c = memo[i - 1] + 1;

            a = Math.min(a, b);
            memo[i] = Math.min(a, c);
        }

        System.out.print(memo[N]);

        br.close();
    }
}
