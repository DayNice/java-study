package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol7569 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[][][] time = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int x = Integer.parseInt(st.nextToken());
                    // 1 : ripe tomato
                    // 0 : fresh tomato
                    // -1 : no tomato
                    if (x == 1) {
                        time[i][j][k] = 0;
                    } else if (x == 0) {
                        time[i][j][k] = INF;
                    } else {
                        time[i][j][k] = -1;
                    }
                }
            }
        }
        setTime(m, n, h, time);
        int out = getMax(m, n, h, time);
        System.out.println(out < INF ? out : -1);
    }

    private static void setTime(int m, int n, int h, int[][][] time) {
        int[] dx = {0, 0, 0, 0, 1, -1};
        int[] dy = {0, 0, 1, -1, 0, 0};
        int[] dz = {1, -1, 0, 0, 0, 0};

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (time[i][j][k] == 0) queue.add(new Point(i, j, k));
                }
            }
        }
        Point p;
        while (!queue.isEmpty()) {
            p = queue.poll();
            for (int i = 0; i < 6; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                int z = p.z + dz[i];
                if (0 <= x && x < h && 0 <= y && y < n && 0 <= z && z < m && time[x][y][z] == INF) {
                    time[x][y][z] = time[p.x][p.y][p.z] + 1;
                    queue.add(new Point(x, y, z));
                }
            }
        }
    }

    private static class Point {
        public int x;
        public int y;
        public int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static int getMax(int m, int n, int h, int[][][] nums) {
        int maxVal = nums[0][0][0];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    maxVal = Math.max(maxVal, nums[i][j][k]);
                }
            }
        }
        return maxVal;
    }
}
