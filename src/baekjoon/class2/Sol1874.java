package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Sol1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int currentNum = 1;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (currentNum <= x) {
                out.append(pushRange(stack, currentNum, x + 1));
                currentNum = x + 1;
            }

            if (Objects.equals(stack.peek(), x)) {
                stack.pop();
                out.append("-\n");
            } else {
                out.setLength(0);
                out.append("NO");
                break;
            }
        }

        System.out.println(out);
    }

    private static String pushRange(Deque<Integer> stack, int first, int last) {
        for (int i = first; i < last; i++) {
            stack.push(i);
        }
        return "+\n".repeat(last > first ? last - first : 0);
    }
}
