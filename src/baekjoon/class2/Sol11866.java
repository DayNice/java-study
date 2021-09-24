package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<String> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }

        List<String> out = new ArrayList<>(n);
        int index = 0;
        while (!list.isEmpty()) {
            index = (index + k - 1) % list.size();
            out.add(list.get(index));
            list.remove(index);
        }

        System.out.println("<" + String.join(", ", out) + ">");
    }
}
