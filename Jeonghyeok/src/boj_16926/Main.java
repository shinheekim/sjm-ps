 package boj_16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,m,r;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr =  new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layer = Math.min(n,m) / 2;


        for(int i = 0; i < layer; i++){
            List<Integer> values = new ArrayList<>();
            List<int[]> positions = new ArrayList<>();
            int startX = i;
            int startY = i;
            int endX = n - i - 1;
            int endY = m - i - 1;

            //위쪽
            for (int y = startY; y < endY; y++) {
                positions.add(new int[]{startX, y});
                values.add(arr[startX][y]);
            }
            // 오른쪽
            for (int x = startX; x < endX; x++) {
                positions.add(new int[]{x, endY});
                values.add(arr[x][endY]);
            }
            // 아래쪽
            for (int y = endY; y > startY; y--) {
                positions.add(new int[]{endX, y});
                values.add(arr[endX][y]);
            }
            // 왼쪽
            for (int x = endX; x > startX; x--) {
                positions.add(new int[]{x, startY});
                values.add(arr[x][startY]);
            }
            int len = values.size();
            int offset = r % len;

            List<Integer> rotated = new ArrayList<>();
            for (int k = 0; k < len; k++) {
                rotated.add(values.get((k + offset) % len));
            }

            for (int k = 0; k < positions.size(); k++) {
                int[] pos = positions.get(k);
                arr[pos[0]][pos[1]] = rotated.get(k);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }


}
