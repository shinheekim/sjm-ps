package pg_3;

class Solution {
    public int solution(int[][] sizes) {
        int answer;
        int h = 0, w = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }
        }

        for (int i = 0; i < sizes.length; i++) {
            h = Math.max(h, sizes[i][0]);
            w = Math.max(w, sizes[i][1]);
        }

        answer = h * w;
        return answer;
    }
}