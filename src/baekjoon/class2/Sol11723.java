package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        boolean[] contains = new boolean[21];
        Arrays.fill(contains, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String w = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (w) {
                case "add":
                    contains[x] = true;
                    break;
                case "remove":
                    contains[x] = false;
                    break;
                case "check":
                    if (contains[x]) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    contains[x] = !contains[x];
                    break;
                case "all":
                    Arrays.fill(contains, true);
                    break;
                case "empty":
                    Arrays.fill(contains, false);
                    break;
            }
        }
        System.out.println(sb);
    }
}
