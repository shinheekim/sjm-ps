package boj_1244;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sw = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sw[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = num; j <= n; j += num) {
                    if (sw[j] == 0) {
                        sw[j] = 1;
                    } else {
                        sw[j] = 0;
                    }
                }
            } else {
                if (sw[num] == 0) {
                    sw[num] = 1;
                } else {
                    sw[num] = 0;
                }

                int d = 1;
                while (num - d >= 1 && num + d <= n) {
                    if (sw[num - d] != sw[num + d]) {
                        break;
                    }

                    if (sw[num - d] == 0) {
                        sw[num - d] = 1;
                    } else {
                        sw[num - d] = 0;
                    }

                    if (sw[num + d] == 0) {
                        sw[num + d] = 1;
                    } else {
                        sw[num + d] = 0;
                    }

                    d++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(sw[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}