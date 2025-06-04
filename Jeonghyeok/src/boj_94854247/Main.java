package boj_94854247;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] time = new int[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (a, b)->{
            if(a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

//        for (int i = 0; i < n; i++) {
//            System.out.println(time[i][0] + " " + time[i][1]);
//        }

        int cnt = 0;
        int endTime = -1;
        for(int i=0; i<n; i++) {
            if(time[i][0] >= endTime) {
                endTime = time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
