package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double total = 0;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        // -4000 ~ 4000
        int[] counts = new int[8001];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            total += x;
            counts[x + 4000]++;
            if (x > maxVal) {
                maxVal = x;
            }
            if (x < minVal) {
                minVal = x;
            }
        }

        int median = 0;
        // index 1 ~ n, median is at (n + 1) / 2
        int index = 0;
        int mode = 0;
        int maxCount = 0;
        boolean unique = false;

        for (int i = minVal + 4000; i <= maxVal + 4000; i++) {
            if (counts[i] > 0) {
                if (index < (n + 1) / 2) {
                    index += counts[i];
                    median = i - 4000;
                }

                if (counts[i] > maxCount) {
                    maxCount = counts[i];
                    mode = i - 4000;
                    unique = true;
                } else if (unique && counts[i] == maxCount) {
                    mode = i - 4000;
                    unique = false;
                }
            }
        }

        String out = Math.round(total / n) + "\n" +
                median + "\n" +
                mode + "\n" +
                (maxVal - minVal) + "\n";

        System.out.println(out);
    }
}
