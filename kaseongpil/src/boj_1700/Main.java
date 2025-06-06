package boj_1700;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> order = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int k = Integer.parseInt(st.nextToken());
            order.add(k);
        }

        int cnt = 0;
        HashSet<Integer> multiTap = new HashSet<>();

        for (int i = 0; i < K; i++) {
            int current = order.get(i);
            order.set(i, 0);
            if (multiTap.size() < N) {
                multiTap.add(current);
                continue;
            }

            if (!multiTap.contains(current)) {
                int target = current;
                int farthest = 0x80000000;
                for (var s : multiTap) {
                    if (!order.contains(s)) {
                        target = s;
                        break;
                    }
                    int index = order.indexOf(s);
                    if (index > farthest) {
                        farthest = index;
                        target = s;
                    }
                }
                cnt++;
                multiTap.remove(target);
                multiTap.add(current);
            }
        }

        bw.write(Integer.toString(cnt));

        br.close();
        bw.flush();
        bw.close();
    }
}
