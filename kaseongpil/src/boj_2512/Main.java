package boj_2512;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] budget;

    static boolean isPossible(int mid) {
        int sum = 0;

        for (var e : budget)
            sum += Math.min(e, mid);

        return sum <= M;
    }

    static int parametricSearch(int max) {
        int answer = 0;
        int left = 0;
        int right = max;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        var st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }

        M = Integer.parseInt(br.readLine());

        bw.write(parametricSearch(max) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
