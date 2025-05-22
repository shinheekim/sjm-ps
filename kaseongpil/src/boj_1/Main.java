package boj_1;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int temp = 1, res = 0;
        char lastBr = ' ';
        Deque<Character> stack = new ArrayDeque<>();
        char[] st = br.readLine().toCharArray();
        for (var ch : st) {
            if (ch == '(') {
                stack.push('(');
                temp *= 2;
            } else if (ch == '[') {
                stack.push('[');
                temp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.print(0);
                    return;
                }
                if (lastBr == '(') res += temp;
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.print(0);
                    return;
                }
                if (lastBr == '[') res += temp;
                stack.pop();
                temp /= 3;
            }
            lastBr = ch;
        }
        if (!stack.isEmpty()) res = 0;
        System.out.print(res);
    }
}
