package boj_17298;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int[] res = new int[N];
        Arrays.fill(res, -1);

        String[] tmpA = br.readLine().split(" ");
        int[] A = new int[N];

        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(tmpA[i]);

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                int cur = stack.pop();
                res[cur] = A[i];
            }
            stack.push(i);
        }
        for (var e : res)
            sb.append(e).append(" ");
        System.out.print(sb);
    }
}
