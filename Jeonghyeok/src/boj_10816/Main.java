 package boj_10816;

import java.io.*;
import java.util.*;


public class Main {

    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            int count = upperBound(target) - lowerBound(target);
            bw.write(count + " ");
        }

        bw.flush();
    }

    static int lowerBound(int target) {
        int left = 0, right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int upperBound(int target) {
        int left = 0, right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if (cards[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}