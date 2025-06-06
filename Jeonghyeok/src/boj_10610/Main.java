// 10610

package boj_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        char[] digits = n.toCharArray();

        int sum = 0;
        boolean hasZero = false;

        for (char c : digits) {
            int digit = c - '0';
            sum += digit;
            if (digit == 0) hasZero = true;
        }

        if (sum % 3 != 0 || !hasZero) {
            System.out.println(-1);
        } else {
            Arrays.sort(digits);
            StringBuilder sb = new StringBuilder(new String(digits));
            System.out.println(sb.reverse().toString());
        }
    }
}