package boj_2110;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int C;
    static int[] house;

    static boolean isPossible(int lastInstalled, int distance) {
        int count = 1;
        for (var e : house)
            if (e - lastInstalled >= distance) {
                count++;
                lastInstalled = e;
            }

        return count >= C;
    }

    static int parametricSearch(int start, int end) {
        int answer = 0;
        while (start <= end) {
            int distance = (start + end) / 2;
            if (isPossible(house[0], distance)) {
                answer = distance;
                start = distance + 1;
            }
            else {
                end = distance - 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, house[i]);
        }

        Arrays.sort(house);
        bw.write(parametricSearch(1, max) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}