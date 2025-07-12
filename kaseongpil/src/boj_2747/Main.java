package boj_2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        long[] memo = new long[n + 1];

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
