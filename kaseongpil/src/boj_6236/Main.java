package boj_6236;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] expenses;

    static boolean isPossible(int k) {
        int count = 1; // 인출 횟수(첫날은 무조건 인출)
        int sum = 0; // 현재 인출액 중 사용한 금액
        for (var e : expenses) {
            if (e > k) { // 오늘 사용해야할 금액이 인출 금액보다 큰 경우
                return false;
            }
            if (sum + e > k) { // 현재 인출한 금액으로 커버할 수 없음
                // ex) 사용 금액 300 + 사용해야할 금액 200 일 때 300 + 200 == k(500)이므로 커버 가능
                count++;
                sum = e; // 새로 인출
            }
            else { // 현재 인출한 금액으로 커버 가능
                sum += e; // 사용 총액 플러스 해줌
            }
        }
        return count <= M;
    }

    static int parametricSearch(int max, int total) {
        int K = total;
        int left = max;
        int right = total;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                right = mid - 1;
                K = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return K;
    }

    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        var bw = new BufferedWriter(new OutputStreamWriter(System.out));

        var st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        expenses = new int[N];

        int max = 0;
        int total = 0;

        for (int i = 0; i < N; i++) {
            expenses[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, expenses[i]);
            total += expenses[i];
        }

        bw.write(parametricSearch(max, total) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
