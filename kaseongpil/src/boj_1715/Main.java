package boj_1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private static int sortingCards() {
        int res = 0;
        while (priorityQueue.size() > 1) {
            int firstCard = priorityQueue.poll();
            int secondCard = priorityQueue.poll();
            int sum = firstCard + secondCard;
            res += sum;
            priorityQueue.offer(sum);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            priorityQueue.offer(Integer.parseInt(br.readLine()));

        System.out.println(sortingCards());
    }
}
