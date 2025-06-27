package boj_14502;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> empty = new ArrayList<>();

    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};

    static int[][] copyArray() {
        int[][] cp = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                cp[i][j] = lab[i][j];
        return cp;
    }

    static int[][] bfs() {
        int[][] temp = copyArray();

        Queue<int[]> q = new ArrayDeque<>();

        for (var e : virus)
            q.offer(e);

        while (!q.isEmpty()) {
            int[] curVirus = q.poll();
            int y = curVirus[0];
            int x = curVirus[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (temp[ny][nx] == 0) {
                    temp[ny][nx] = 2;
                    q.offer(new int[]{ny, nx});
                }
            }
        }
        return temp;
    }

    static int getArea(int[][] copyArr) {
        int area = 0;
        for (var r : copyArr)
            for (var c : r)
                if (c == 0) area++;
        return area;
    }

    static int buildAndGetMaxArea() {
        int area = 0;
        int emptyLength = empty.size();
        for (int i = 0; i < emptyLength - 2; i++) {
            int[] firstWall = empty.get(i);
            for (int j = i + 1; j < emptyLength - 1; j++) {
                int[] secondWall = empty.get(j);
                for (int k = j + 1; k < emptyLength; k++) {
                    int[] thirdWall = empty.get(k);

                    lab[firstWall[0]][firstWall[1]] = 1;
                    lab[secondWall[0]][secondWall[1]] = 1;
                    lab[thirdWall[0]][thirdWall[1]] = 1;

                    area = Math.max(area, getArea(bfs()));

                    lab[firstWall[0]][firstWall[1]] = 0;
                    lab[secondWall[0]][secondWall[1]] = 0;
                    lab[thirdWall[0]][thirdWall[1]] = 0;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) virus.add(new int[]{i, j});
                else if (lab[i][j] == 0) empty.add(new int[]{i, j});
            }
        }

        bw.write(buildAndGetMaxArea() + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
