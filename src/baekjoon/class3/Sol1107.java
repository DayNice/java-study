package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] isBroken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());
                isBroken[x] = true;
            }
        }
        int out = getNum(n, m, isBroken);
        System.out.println(out);
    }

    private static int getNum(int n, int m, boolean[] isBroken) {
        int minVal = Math.abs(n - 100);
        if (m == 10) {
            return minVal;
        }
        for (int i = 0; i < 1000000; i++) {
            int r = getButtonCount(isBroken, i);
            if (r != -1) {
                minVal = Math.min(minVal, r + Math.abs(n - i));
            }
        }
        return minVal;
    }

    private static int getButtonCount(boolean[] isBroken, int x) {
        // returns the button count required to get x
        // if a button is unavailable return -1
        if (x == 0) {
            return isBroken[0] ? -1 : 1;
        }
        int count = 0;
        while (x > 0) {
            if (isBroken[x % 10]) {
                return -1;
            }
            count++;
            x = x / 10;
        }
        return count;
    }
}
