package boj_10826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String adder(String n1, String n2) {
        StringBuilder result = new StringBuilder();
        int len1 = n1.length();
        int len2 = n2.length();
        int maxLength = Math.max(len1, len2);
        int carry = 0;
        for (int i = 0; i < maxLength; i++) {
            int a = (len1 - 1 - i >= 0) ? n1.charAt(len1 - 1 - i) - '0' : 0;
            int b = (len2 - 1 - i >= 0) ? n2.charAt(len2 - 1 - i) - '0' : 0;
            int sum = a + b + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) result.append(carry);
        return result.reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] memo = new String[n + 1];

        memo[0] = "0";
        if (n > 0) {
            memo[1] = "1";
            for (int i = 2; i <= n; i++)
                memo[i] = adder(memo[i - 1], memo[i - 2]);
        }
        System.out.print(memo[n]);

        br.close();
    }
}
