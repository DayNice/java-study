package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol18111 {
    public static void main(String[] args) throws IOException {
        // get n, m, b
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // get data
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // brute search
        StringBuilder out = getBestLevel(n, m, b, data);

        System.out.println(out);
    }

    private static StringBuilder getBestLevel(int n, int m, int b, int[][] data) {
        int maxHeight = Math.min(256, (b + getBlockCount(data)) / (n * m));
        int bestLevel = 0;
        int bestTime = Integer.MAX_VALUE;

        for (int level = maxHeight; level >= 0; level--) {
            int time = getTime(data, level);
            if (time < bestTime) {
                bestTime = time;
                bestLevel = level;
            }
        }

        return new StringBuilder().append(bestTime).append(' ').append(bestLevel);
    }

    private static int getTime(int[][] data, int level) {
        int time = 0;
        for (int[] datum : data) {
            for (int i : datum) {
                if (i > level) {
                    time += 2 * (i - level);
                } else {
                    time += (level - i);
                }
            }
        }
        return time;
    }

    private static int getBlockCount(int[][] data) {
        int total = 0;
        for (int[] datum : data) {
            for (int i : datum) {
                total += i;
            }
        }
        return total;
    }
}
