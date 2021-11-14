package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sol2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] data = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = line.charAt(j) == '1';
            }
        }
        List<Integer> nums = getNums(n, data);
        System.out.println(nums.size());
        for (int x : nums) {
            System.out.println(x);
        }
    }

    private static List<Integer> getNums(int n, boolean[][] unvisited) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (unvisited[i][j]) {
                    nums.add(spread(n, unvisited, new Point(i, j)));
                }
            }
        }
        nums.sort(null);
        return nums;
    }

    private static int spread(int n, boolean[][] unvisited, Point p) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.add(p);
        unvisited[p.x][p.y] = false;
        int count = 0;
        while (!queue.isEmpty()) {
            p = queue.poll();
            count += 1;
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (0 <= x && x < n && 0 <= y && y < n && unvisited[x][y]) {
                    unvisited[x][y] = false;
                    queue.add(new Point(x, y));
                }
            }
        }
        return count;
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
