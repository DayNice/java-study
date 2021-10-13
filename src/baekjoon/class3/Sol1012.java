package baekjoon.class3;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol1012 {
    private static final int[] dx = new int[]{0, 0, 1, -1};
    private static final int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            boolean[][] unchecked = new boolean[m][n];
            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                unchecked[x][y] = true;
            }

            String out = String.valueOf(getNum(unchecked, m, n));
            bw.write(out);
            bw.newLine();
        }
        bw.flush();
    }

    private static int getNum(boolean[][] unchecked, int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (unchecked[i][j]) {
                    count++;
                    search(unchecked, m, n, i, j);
                }
            }
        }
        return count;
    }

    private static void search(boolean[][] unchecked, int m, int n, int x, int y) {
        Queue<Integer[]> queue = new LinkedList<>();
        unchecked[x][y] = false;
        queue.add(new Integer[]{x, y});
        while (!queue.isEmpty()) {
            Integer[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                x = p[0] + dx[i];
                y = p[1] + dy[i];
                if (0 <= x && x < m && 0 <= y && y < n && unchecked[x][y]) {
                    unchecked[x][y] = false;
                    queue.add(new Integer[]{x, y});
                }
            }
        }
    }
}
