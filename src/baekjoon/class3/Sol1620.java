package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sol1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 0 ~ n
        String[] words = new String[n + 1];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            words[i] = br.readLine();
            map.put(words[i], i);
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String w = br.readLine();
            Integer x = map.get(w);
            if (x == null) {
                out.append(words[Integer.parseInt(w)]).append("\n");
            } else {
                out.append(x).append("\n");
            }
        }

        System.out.println(out);
    }
}
