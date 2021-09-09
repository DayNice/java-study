package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int count = 0, result = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                result += count;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
