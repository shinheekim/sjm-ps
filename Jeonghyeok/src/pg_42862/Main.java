package pg_42862;
import java.util.Arrays;

public class Main {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n + 2];
        Arrays.fill(students, 1);

        for (int r : reserve) {
            students[r]++;
        }
        for (int l : lost) {
            students[l]--;
        }

        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {
                if (students[i - 1] == 2) {
                    students[i]++;
                    students[i - 1]--;
                } else if (students[i + 1] == 2) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] >= 1) answer++;
        }

        return answer;
    }
}