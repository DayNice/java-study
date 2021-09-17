package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String w = br.readLine();
        StringBuilder sb = new StringBuilder();

        while (!w.equals("0")) {
            StringBuilder temp = new StringBuilder(w);
            if (temp.reverse().toString().equals(w)) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
            w = br.readLine();
        }

        System.out.println(sb);
    }
}
