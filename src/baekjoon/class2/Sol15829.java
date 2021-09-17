package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String w = br.readLine();

        long out = 0;
        for (int i = 0; i < l; i++) {
            long x = 1;
            for (int j = 0; j < i; j++) {
                x *= 31;
                x %= 1234567891;
            }
            out += (w.charAt(i) - 96) * x;
            out %= 1234567891;
        }

        System.out.println(out);
    }
}
