package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol7576 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] time = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int x = Integer.parseInt(st.nextToken());
                // 1 : ripe tomato
                // 0 : fresh tomato
                // -1 : no tomato
                if (x == 1) {
                    time[i][j] = 0;
                } else if (x == 0) {
                    time[i][j] = INF;
                } else {
                    time[i][j] = -1;
                }
            }
        }
        setTime(m, n, time);
        int out = getMax(m, n, time);
        System.out.println(out < INF ? out : -1);
    }

    private static void setTime(int m, int n, int[][] time) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (time[i][j] == 0) queue.add(new Point(i, j));
            }
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (0 <= x && x < n && 0 <= y && y < m && time[x][y] == INF) {
                    time[x][y] = time[p.x][p.y] + 1;
                    queue.add(new Point(x, y));
                }
            }
        }
    }

    private static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int getMax(int m, int n, int[][] time) {
        int maxVal = time[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxVal = Math.max(maxVal, time[i][j]);
            }
        }
        return maxVal;
    }
}
