package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] linked = new boolean[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            // zero-base
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            linked[i][j] = linked[j][i] = true;
        }
        String out = String.valueOf(getNum(n, linked));
        System.out.println(out);
    }

    private static int getNum(int n, boolean[][] linked) {
        int num = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                spread(n, linked, visited, i);
                num++;
            }
        }
        return num;
    }

    private static void spread(int n, boolean[][] linked, boolean[] visited, int x) {
        visited[x] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < n; j++) {
                if (linked[i][j] && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
