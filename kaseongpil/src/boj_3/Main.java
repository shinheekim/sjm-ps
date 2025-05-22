package boj_3;
import java.io.*;
import java.util.*;

public class Main {
    static class Person {
        int height, count;
        Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Person> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        long res = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int count = 1;
            while (!stack.isEmpty() && stack.peek().height <= height) {
                Person p = stack.pop();
                res += p.count;
                if (p.height == height)
                    count += p.count;
            }
            if (!stack.isEmpty()) res++;
            stack.push(new Person(height, count));
        }
        System.out.print(res);
    }
}
