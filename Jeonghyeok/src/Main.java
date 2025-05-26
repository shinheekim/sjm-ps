import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, b;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        b = new int[n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        sol(0);
        System.out.println(max);
    }

    public static void sol(int index) {
        if(index == n) {
            int sum = 0;
            for(int i = 0; i < n - 1; i++) {
                sum += Math.abs(b[i] - b[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                b[index] = a[i];
                sol(index + 1);
                visited[i] = false;
            }
        }
    }
}