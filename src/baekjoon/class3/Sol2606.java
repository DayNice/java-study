package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] links = new boolean[n][n];

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            links[i][j] = links[j][i] = true;
        }

        int out = getNum(links);
        System.out.println(out);
    }

    private static int getNum(boolean[][] links) {
        int count = 0;
        boolean[] visited = new boolean[links.length];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < links.length; j++) {
                if (links[i][j] && !visited[j]) {
                    visited[j] = true;
                    count++;
                    queue.add(j);
                }
            }
        }
        return count;
    }
}
