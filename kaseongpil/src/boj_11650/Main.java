package boj_11650;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Point[] point = new Point[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(point, (cur, pos) -> {
            if (cur.x != pos.x) return cur.x - pos.x;
            return cur.y - pos.y;
        });

        StringBuilder sb = new StringBuilder();

        for (var p : point)
            sb.append(p.x).append(" ").append(p.y).append("\n");

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }
}
