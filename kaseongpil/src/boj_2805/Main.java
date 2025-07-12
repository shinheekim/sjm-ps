package boj_2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] woods;

    static long getWood(int H) {
        long sum = 0;
        for (var e : woods)
            sum += Math.max(e - H, 0);
        return sum;
    }

    static int parametricSearch(int start, int end) {
        int answer = 0;
        while (start <= end) {
            int H = (start + end) / 2;
            long obtained = getWood(H);
            if (obtained >= M) {
                answer = H;
                start = H + 1;
            }
            else end = H - 1;
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        woods = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < N; i++) {
            int wood = Integer.parseInt(st.nextToken());
            max = Math.max(max, wood);
            woods[i] = wood;
        }

        bw.write(parametricSearch(0, max) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}