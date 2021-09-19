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
        long r = 1;
        for (int i = 0; i < l; i++) {
            out += (w.charAt(i) - 96) * r;
            out %= 1234567891;
            r *= 31;
            r %= 1234567891;
        }

        System.out.println(out);
    }
}
