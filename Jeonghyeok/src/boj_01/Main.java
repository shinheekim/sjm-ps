package boj_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int temp = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                temp *= 2;
                stack.push(ch);
            } else if (ch == '[') {
                temp *= 3;
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '(') {
                    result += temp;
                }
                stack.pop();
                temp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (input.charAt(i - 1) == '[') {
                    result += temp;
                }
                stack.pop();
                temp /= 3;
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
