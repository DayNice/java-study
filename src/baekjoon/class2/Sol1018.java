package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] colors = new char[n][m];
        for (int i = 0; i < n; i++) {
            br.read(colors[i], 0, m);
            br.read();
        }

        int out = 32;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int num = countDiff(i, j, colors);
                if (num < out) {
                    out = num;
                }
            }
        }

        System.out.println(out);
    }

    private static int countDiff(int x, int y, char[][] colors) {
        int out = 0;
        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (colors[i][j] != 'B') {
                        out++;
                    }
                } else {
                    if (colors[i][j] != 'W') {
                        out++;
                    }
                }
            }
        }
        return Math.min(out, 64 - out);
    }
}
