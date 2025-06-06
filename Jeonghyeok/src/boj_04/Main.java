package boj_04;
// N과 M (1)
import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static int m;

    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth){
        if (depth == m){
            for(int val : arr){
                sb.append(val).append(' ');
            }
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);

                visit[i] = false;
            }
        }

    }
}