package boj_2749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int pisanoPeriod(int mod) {
        int pre = 0, cur = 1, next;
        int count = 0;
        while (true) {
            count++;
            next = (pre + cur) % mod;
            pre = cur;
            cur = next;

            if (pre == 0 && cur == 1) return count;
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        int mod = 1_000_000;
        int pisano = pisanoPeriod(mod);
        int idx = (int)(n % pisano);

        int[] memo = new int[idx + 1];
        memo[1] = 1;

        for (int i = 2; i <= idx; i++)
            memo[i] = (memo[i - 1] + memo[i - 2]) % mod;

        System.out.print(memo[idx]);
    }
}
