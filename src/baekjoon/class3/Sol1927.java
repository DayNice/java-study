package baekjoon.class3;

import java.io.*;
import java.util.PriorityQueue;

public class Sol1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else {
                int v = pq.isEmpty() ? 0 : pq.poll();
                bw.write(String.valueOf(v));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
