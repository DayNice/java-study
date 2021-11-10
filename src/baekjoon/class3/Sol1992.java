package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol1992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] data = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = line.charAt(j);
            }
        }
        StringBuilder out = new StringBuilder();
        setAnswer(out, data, n, 0, 0);
        System.out.println(out);
    }

    private static void setAnswer(StringBuilder out, char[][] data, int n, int x, int y) {
        if (n == 1 || check(data, n, x, y)) {
            out.append(data[x][y]);
            return;
        }
        out.append('(');
        n = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                setAnswer(out, data, n, x + i * n, y + j * n);
            }
        }
        out.append(')');
    }

    private static boolean check(char[][] data, int n, int x, int y) {
        char ref = data[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (data[i][j] != ref) {
                    return false;
                }
            }
        }
        return true;
    }
}
