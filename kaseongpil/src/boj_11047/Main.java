package boj_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = N - 1; i >= 0; i--)
            while (K / A[i] != 0) {
                res += K / A[i];
                K -= A[i] * (K / A[i]);
            }

        System.out.println(res);
        br.close();
    }
}
