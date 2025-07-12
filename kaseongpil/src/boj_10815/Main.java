package boj_10815;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] cards;
    static int[] checkList;

    static int binarySearch(int target) {
        int left = 0;
        int right = cards.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cards[mid] < target) left = mid + 1;
            else if (cards[mid] > target) right = mid - 1;
            else return 1;
        }
        return 0;
    }

    static StringBuilder isContain() {
        var sb = new StringBuilder();

        for (var e : checkList)
            sb.append(binarySearch(e)).append(" ");

        return sb;
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        checkList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        var sb = isContain();

        System.out.print(sb);

        br.close();
    }
}
