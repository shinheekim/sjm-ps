package boj_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n / 10 != 0){
            cnt += n % 10;
            cnt /= 10;
        }
        System.out.println(cnt);




    }
}
