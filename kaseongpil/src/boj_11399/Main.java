package boj_11399;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] minute;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minute = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            minute[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(minute);
        System.out.println(sum());
    }
    static int sum() {
        int[] time = new int[N];
        int res = time[0] = minute[0];
        for (int i = 1; i < N; i++) {
            time[i] = time[i - 1] + minute[i];
            res += time[i];
        }
        return res;
    }
}
