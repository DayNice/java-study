package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int count = 0;
            boolean balanced = true;
            int c = br.read();
            while (c != '\n') {
                if (c == '(') {
                    count++;
                } else {
                    if (count > 0) {
                        count--;
                    } else {
                        balanced = false;
                        br.readLine();
                        break;
                    }
                }
                c = br.read();
            }
            if (count > 0) {
                balanced = false;
            }
            out.append(balanced ? "YES\n" : "NO\n");
        }

        System.out.println(out);
    }
}
