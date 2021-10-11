package baekjoon.class3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Sol9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                map.merge(st.nextToken(), 1, Integer::sum);
            }
            String out = String.valueOf(getNum(map));
            bw.write(out);
            bw.newLine();
        }
        bw.flush();
    }

    private static int getNum(Map<String, Integer> map) {
        int num = 1;
        for (Integer x : map.values()) {
            num *= x + 1;
        }
        return num - 1;
    }
}
