package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Sol1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            List<int[]> list = new LinkedList<>();
            // priority range 1 ~ 9
            int[] counts = new int[10];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                list.add(new int[]{x, i});
                counts[x]++;
            }

            boolean done = false;
            int num = 0;
            int index = 0;
            for (int i = 9; i >= 1; i--) {
                while (counts[i]-- > 0) {
                    index = index % list.size();
                    while (list.get(index)[0] != i) {
                        index = (index + 1) % list.size();
                    }
                    num++;
                    int r = list.get(index)[1];
                    list.remove(index);

                    if (r == m) {
                        out.append(num).append("\n");
                        done = true;
                        break;
                    }
                }
                if (done) {
                    break;
                }
            }
        }

        System.out.println(out);
    }
}
