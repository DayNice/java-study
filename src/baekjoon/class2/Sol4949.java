package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Sol4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();

        StringBuilder out = new StringBuilder();
        String line = br.readLine();
        while (!line.equals(".")) {
            boolean balanced = true;
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.peek() == Character.valueOf('(')) {
                        stack.pop();
                    } else {
                        balanced = false;
                        break;
                    }
                } else if (c == ']') {
                    if (stack.peek() == Character.valueOf('[')) {
                        stack.pop();
                    } else {
                        balanced = false;
                        break;
                    }
                }
            }
            if (stack.size() > 0) {
                balanced = false;
            }
            stack.clear();
            out.append(balanced ? "yes\n" : "no\n");
            line = br.readLine();
        }

        System.out.println(out);
    }

    public static void main_alt(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> stack = new ArrayDeque<>();

        StringBuilder out = new StringBuilder();
        int c = br.read();
        while (c != -1 && c != '.') {
            boolean balanced = true;
            while (c != '\n') {
                if (c == '(' || c == '[') {
                    stack.push((char) c);
                } else if (c == ')') {
                    if (stack.peek() == Character.valueOf('(')) {
                        stack.pop();
                    } else {
                        balanced = false;
                        br.readLine();
                        break;
                    }
                } else if (c == ']') {
                    if (stack.peek() == Character.valueOf('[')) {
                        stack.pop();
                    } else {
                        balanced = false;
                        br.readLine();
                        break;
                    }
                }
                c = br.read();
            }
            if (stack.size() > 0) {
                balanced = false;
            }
            stack.clear();
            out.append(balanced ? "yes\n" : "no\n");
            c = br.read();
        }

        System.out.println(out);
    }
}
