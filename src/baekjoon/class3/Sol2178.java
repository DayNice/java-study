package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] data = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                data[i][j] = line.charAt(j);
            }
        }
        int out = getDistance(n, m, data);
        System.out.println(out);
    }

    private static int getDistance(int n, int m, char[][] data) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int[][] distances = new int[n][m];
        distances[0][0] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (0 <= x && x < n && 0 <= y && y < m && data[x][y] == '1' && distances[x][y] == 0) {
                    distances[x][y] = distances[p.x][p.y] + 1;
                    queue.add(new Pair(x, y));
                }
            }
        }
        return distances[n - 1][m - 1];
    }

    private static class Pair {
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
