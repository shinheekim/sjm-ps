package boj_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] queen;

    static boolean isPossible(int row, int column) {
        for (int i = 0; i < row; i++) // 'i' is the currently iterated row, queen[i] is column of queen
            if (queen[i] == column || Math.abs(column - queen[i]) == Math.abs(row - i)) return false;
                // 현재 내가 있는 열에 queen이 있나
                // 각 행의 queen의 대각선을 확인 (대각선 상에 존재하는 모든 값은 x - y의 절대값이 같음)
        return true;
    }

    static int dfs(int row) {
        if (row == N)
            return 1;

        int result = 0;

        for (int i = 0; i < N; i++) { // the role of i is column.
            if (isPossible(row, i)) {
                queen[row] = i;
                result += dfs(row + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        queen = new int[N];

        System.out.println(dfs(0));
    }
}
