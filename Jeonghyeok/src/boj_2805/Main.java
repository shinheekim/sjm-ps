package boj_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }

        int left = 0;
        int right = max;
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = getWood(mid);

            if (sum >= m) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }

    static long getWood(int height) {
        long sum = 0;
        for (int t : trees) {
            if (t > height) {
                sum += (t - height);
            }
        }
        return sum;
    }
}