package boj_1904;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int MOD = 15746;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if (n == 1) {
            System.out.println(1);
            return;
        }

        int a = 1, b = 2, result = 0;

        for (int i = 3; i <= n; i++) {
            result = (a + b) % MOD;
            a = b;
            b = result;
        }

        System.out.println(b);
    }
}