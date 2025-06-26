package boj_2606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] network;
    static int computer;

    static int dfs(int virus) {
        var stk = new ArrayDeque<Integer>();
        var visited = new boolean[computer + 1];
        var cnt = 0;

        stk.push(virus);

        while (!stk.isEmpty()) {
            virus = stk.pop();
            if (visited[virus]) {
                continue;
            }
            visited[virus] = true;
            cnt++;
            for (int i = 1; i <= computer; i++) {
                if (network[virus][i] && !visited[i]) {
                    stk.push(i);
                }
            }
        }
        return cnt - 1;
    }

    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        computer = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        network = new boolean[computer + 1][computer + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            var c = Integer.parseInt(st.nextToken());
            var l = Integer.parseInt(st.nextToken());
            network[c][l] = true;
            network[l][c] = true;
        }

        bw.write(dfs(1) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
