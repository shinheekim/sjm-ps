package boj_10610;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int sum = 0;
        int[] arr = new int[10];

        for (var e : N.toCharArray()) {
            int digit = e - '0';
            arr[digit]++;
            sum += digit;
        }

        if (arr[0] > 0 && sum % 3 == 0)
            for (int i = 9; i >= 0; i--)
                for (int j = 0; j < arr[i]; j++)
                    bw.write(i + '0');
        else
            bw.write("-1");
        br.close();
        bw.flush();
        bw.close();
    }
}
