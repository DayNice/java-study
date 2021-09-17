package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int out = 0;

        for (int i = 1; i < n; i++) {
            if (digitSum(i) == n) {
                out = i;
                break;
            }
        }

        System.out.println(out);
    }

    public static int digitSum(int i) {
        int out = i;
        while (i > 0) {
            out += i % 10;
            i /= 10;
        }
        return out;
    }
}
