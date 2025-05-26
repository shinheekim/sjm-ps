package boj_2798;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String[] cards = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int min = 0x7FFF_FFFF;

        for (int i = 0; i < N; i++) {
            int firstCard = Integer.parseInt(cards[i]);
            for (int j = i + 1; j < N; j++) {
                int secondCard = Integer.parseInt(cards[j]);
                for (int k = j + 1; k < N; k++) {
                    int thirdCard = Integer.parseInt(cards[k]);
                    int temp = M - (firstCard + secondCard + thirdCard);
                    if (temp >= 0 && temp < min)
                        min = temp;
                }
            }
        }
        System.out.println(M - min);
    }
}
