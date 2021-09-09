package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 'a'; i <= 'z'; i++) {
            sb.append(line.indexOf(i)).append(" ");
        }

        System.out.println(sb);
    }
}
