package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(getNum(n, r, c));
    }

    private static int getNum(int n, int r, int c) {
        if (n == 1) return r * 2 + c;
        int ref = 1 << --n;
        return ((r / ref) * 2 + (c / ref)) * (ref * ref) + getNum(n, r % ref, c % ref);
    }
}
