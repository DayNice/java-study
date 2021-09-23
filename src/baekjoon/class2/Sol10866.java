package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Sol10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        while (n-- > 0) {
            int x;
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push_front":
                    x = Integer.parseInt(st.nextToken());
                    deque.addFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(st.nextToken());
                    deque.addLast(x);
                    break;
                case "pop_front":
                    out.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    out.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
                    break;
                case "size":
                    out.append(deque.size()).append("\n");
                    break;
                case "empty":
                    out.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    out.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "back":
                    out.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(out);
    }
}
