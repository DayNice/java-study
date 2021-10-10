package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] colors = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] out = getNums(colors, n, 0, 0);
        System.out.println(out[0]);
        System.out.println(out[1]);
    }

    private static int[] getNums(int[][] colors, int n, int x, int y) {
        int[] counts = new int[2];
        if (check(colors, n, x, y)) {
            int ref = colors[x][y];
            counts[ref]++;
            return counts;
        }
        n /= 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int[] temp = getNums(colors, n, x + i * n, y + j * n);
                counts[0] += temp[0];
                counts[1] += temp[1];
            }
        }
        return counts;
    }

    private static boolean check(int[][] colors, int n, int x, int y) {
        int ref = colors[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (colors[i][j] != ref) {
                    return false;
                }
            }
        }
        return true;
    }
}
