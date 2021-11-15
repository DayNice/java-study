package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

public class Sol6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            // zero-base
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int out = getNum(m, n, x, y);
            bw.write(String.valueOf(out));
            bw.newLine();
        }
        bw.flush();
    }

    private static int getNum(int m, int n, int x, int y) {
        // Brute force
        if (m > n) {
            return getNum(n, m, y, x);
        }
        for (int i = x; i < m * n; i += m) {
            if (i % n == y) {
                return i + 1;
            }
        }
        return -1;
    }
}
