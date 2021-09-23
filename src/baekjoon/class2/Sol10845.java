package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    queue.add(x);
                    break;
                case "pop":
                    out.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case "size":
                    out.append(queue.size()).append("\n");
                    break;
                case "empty":
                    out.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    out.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                    break;
                case "back":
                    out.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(out);
    }
}
