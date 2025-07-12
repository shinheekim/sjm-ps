package boj_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(br.readLine()));
        while (pq.size() > 1) {
            int firstCard = pq.poll();
            int secondCard = pq.poll();
            int sumCards = firstCard + secondCard;
            ans += sumCards;
            pq.offer(sumCards);
        }
        System.out.print(ans);
    }
}
