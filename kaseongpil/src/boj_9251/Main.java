package boj_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        var str1 = br.readLine();
        var str2 = br.readLine();

        int s1 = str1.length();
        int s2 = str2.length();

        var memo = new int[s1 + 1][s2 + 1];

        for (int i = 1; i <= s1; i++) { // ACAYK
            for (int j = 1; j <= s2; j++) { // CAPCAK
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // 같으면
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else { // 다르면
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        /*    C A P C A K
            0 0 0 0 0 0 0
            0 0 1 1 1 1 1 A
            0 1 1 1 2 2 2 C
            0 1 2 2 2 3 3 A
            0 1 2 2 2 3 3 Y
            0 1 2 2 2 3 4 K
            0 1 2 3 3 3 4 P
         */

        System.out.print(memo[s1][s2]);

        br.close();
    }
}
