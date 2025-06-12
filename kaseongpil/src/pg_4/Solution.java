package pg_4;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] list = new int[n + 1];

        for (int i = 1; i <= n; i++)
            list[i] = 1;
        for (var e : lost)
            list[e]--;
        for (var e : reserve)
            list[e]++;

        for (int i = 1; i <= n; i++) {
            if (list[i] > 0) answer++;
            else {
                if (list[i - 1] > 1) {
                    list[i - 1]--;
                    list[i]++;
                    answer++;
                }
                else if (i < n && list[i + 1] > 1) {
                    list[i + 1]--;
                    list[i]++;
                    answer++;
                }
            }
        }
        return answer;
    }
}