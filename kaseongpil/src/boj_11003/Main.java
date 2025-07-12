package boj_11003;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Deque<Integer> deque = new ArrayDeque<>();
    static int N, L;
    static int[] A;

    static void slidingWindow() throws IOException {
        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - L + 1)
                deque.pollFirst();

            while (!deque.isEmpty() && A[deque.peekLast()] > A[i])
                deque.pollLast();

            deque.offerLast(i);

            bw.write(A[deque.peekFirst()] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        slidingWindow();

        br.close();
        bw.flush();
        bw.close();
    }
}
