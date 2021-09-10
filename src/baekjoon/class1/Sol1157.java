package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = new int[26];
        Arrays.fill(counts, 0);

        for (char c : br.readLine().toUpperCase().toCharArray()) {
            counts[c - 'A']++;
        }

        char result = '?';
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int num = counts[c - 'A'];
            if (num > max) {
                result = c;
                max = num;
            } else if (num == max) {
                result = '?';
            }
        }

        System.out.println(result);
    }
}
