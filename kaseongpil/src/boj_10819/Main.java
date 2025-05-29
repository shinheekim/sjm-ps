package boj_10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int[] tempA;
    static boolean[] visited;

    private static int dfs(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++)
                sum += Math.abs(tempA[i] - tempA[i + 1]);
            return sum;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++)
            if (!visited[i]) {
                visited[i] = true;
                tempA[depth] = A[i];
                max = Math.max(max, dfs(depth + 1));
                visited[i] = false;
            }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        tempA = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        System.out.println(dfs(0));
    }
}
