package boj_1654;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] lanCable;

    static boolean isPossible(long cm) {
        long cable = 0;
        for (int i = 0; i < K; i++) {
            cable += lanCable[i] / cm;
        }
        return cable >= N;
    }

    static long parametricSearch(long left, long right) {
        long cm = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (isPossible(mid)) {
                left = mid + 1;
                cm = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return cm;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lanCable = new int[K];

        int max = 0;

        for (int i = 0; i < K; i++) {
            lanCable[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lanCable[i]);
        }

        bw.write(parametricSearch(1, max) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
