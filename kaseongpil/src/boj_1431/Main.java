package boj_1431;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = br.readLine();
        Arrays.sort(arr, (a, b) -> {
            int aLength = a.length();
            int bLength = b.length();
            if (aLength != bLength) return aLength - bLength;
            int aSum = 0;
            for (var c : a.toCharArray()) {
                if (c >= '0' && c <= '9')
                    aSum += c - '0';
            }
            int bSum = 0;
            for (var c : b.toCharArray()) {
                if (c >= '0' && c <= '9')
                    bSum += c - '0';
            }
            if (aSum != bSum) return aSum - bSum;
            return a.compareTo(b);
        });
        for (var e : arr)
            bw.write(e + "\n");
        bw.flush();
        bw.close();
        br.close();

    }
}
