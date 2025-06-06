package boj_1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++)
            set.add(br.readLine());
        List<String> list = new ArrayList<>(set);

        list.sort((a, b) -> {
            int aLength = a.length();
            int bLength = b.length();
            if (aLength != bLength) return aLength - bLength;
            return a.compareTo(b);
        });

        for (var e : list)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
