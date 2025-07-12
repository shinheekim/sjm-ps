package boj_16926;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] A;

    static void rotateArray() {
        for (int layer = 0; layer < Math.min(N, M) / 2; layer++) {
            int top = layer;
            int bottom = N - 1 - layer;
            int left = layer;
            int right = M - 1 - layer;

            int perimeter = 2 * ((bottom - top) + (right - left));
            int[] ring = new int[perimeter];

            int idx = 0;

            for (int i = left; i < right; i++)
                ring[idx++] = A[top][i];

            for (int i = top; i < bottom; i++)
                ring[idx++] = A[i][right];

            for (int i = right; i > left; i--)
                ring[idx++] = A[bottom][i];

            for (int i = bottom; i > top; i--)
                ring[idx++] = A[i][left];

            int r = R % perimeter;
            idx = 0;

            for (int i = left; i < right; i++)
                A[top][i] = ring[(idx++ + r) % perimeter];

            for (int i = top; i < bottom; i++)
                A[i][right] = ring[(idx++ + r) % perimeter];

            for (int i = right; i > left; i--)
                A[bottom][i] = ring[(idx++ + r) % perimeter];

            for (int i = bottom; i > top; i--)
                A[i][left] = ring[(idx++ + r) % perimeter];
        }
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        rotateArray();

        for (var e : A) {
            for (var f : e)
                bw.write(f + " ");
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
