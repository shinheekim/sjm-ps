package boj_18352;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    // N = 도시의 개수(Node)
    // M = 도로의 개수(Edge)
    // K = 거리 정보(최단거리가 K인 도시)
    // X = 출발 도시의 번호
    static List<List<Integer>> map = new ArrayList<>();
    static int[] distance;

    static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(X);
        distance[X] = 0;

        while (!q.isEmpty()) {
            var cur = q.poll();
            for (var e : map.get(cur)) {
                if (distance[e] != -1) continue;
                q.offer(e);
                distance[e] = distance[cur] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i <= N; i++)
            map.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int city = Integer.parseInt(st.nextToken());
            int road = Integer.parseInt(st.nextToken());
            map.get(city).add(road);
        }

        List<Integer> answer = new ArrayList<>();

        bfs();

        for (int i = 1; i <= N; i++)
            if (distance[i] == K) answer.add(i);

        if (answer.isEmpty()) bw.write("-1");
        else {
            Collections.sort(answer);
            for (var e : answer)
                bw.write(e + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
