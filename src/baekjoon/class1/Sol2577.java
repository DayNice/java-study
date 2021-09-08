package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        for (int i = 0; i < 3; i++) {
            num *= Integer.parseInt(br.readLine());
        }

        int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        while (num > 0) {
            int digit = num % 10;
            counts[digit] += 1;
            num /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(counts[i]).append("\n");
        }
        System.out.println(sb);
    }
}
