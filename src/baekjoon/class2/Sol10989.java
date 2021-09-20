package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] counts = new int[10_001];
        while (n-- > 0) {
            counts[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                out.append((i + "\n").repeat(counts[i]));
            }
        }

        System.out.println(out);
    }
}
