package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Sol10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        out.append(stack.pop()).append("\n");
                    } else {
                        out.append(-1).append("\n");
                    }
                    break;
                case "size":
                    out.append(stack.size()).append("\n");
                    break;
                case "empty":
                    out.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        out.append(stack.peek()).append("\n");
                    } else {
                        out.append(-1).append("\n");
                    }
                    break;
            }
        }

        System.out.println(out);
    }
}
