package boj_4;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            while (!deque.isEmpty() && deque.peek() > A[i])
                deque.pollFirst();
            deque.addLast(A[i]);
            if (deque.size() > L && deque.peekFirst() == A[i - L])
                deque.pollLast();
            bw.write(deque.peekFirst() + " ");
        }
    }
}
