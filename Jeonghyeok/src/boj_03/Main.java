 package boj_03;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] garden;
    static boolean[][] visited;
    static int minCost = Integer.MAX_VALUE;
    static int[] dx = {0,0,1, -1};
    static int[] dy = {1,-1,0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        garden = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++ ){
                garden[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        bw.write(String.valueOf(minCost));
        bw.flush();
    }

    static void dfs(int depth, int cost){
        if(depth == 3) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for(int i = 1; i < n-1; i++){
            for(int j = 1; j  < n-1; j++){
                if(isPlant(i, j)){
                    int temp = plant(i,j);
                    dfs(depth+1, cost + temp);
                    remove(i, j);
                }
            }
        }
    }
    static boolean isPlant(int x, int y){
        if(visited[x][y]){
            return false;
        }
        for(int i = 0; i < 4; i ++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(visited[nx][ny]){
                return false;
            }
        }
        return true;

    }

    static int plant(int x, int y){
        visited[x][y] = true;
        int sum = garden[x][y];
        for(int i=0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = true;
            sum +=  garden[nx][ny];
        }
        return sum;
    }
    static void remove(int x, int y) {
        visited[x][y] = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = false;
        }
    }
}
