package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Sol10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        while (k-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                stack.pop();
            } else {
                stack.push(x);
            }
        }

        System.out.println(stack.stream().reduce(0, Integer::sum));
    }
}
