package baekjoon.class3;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Sol11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pq.add(x);
            } else {
                bw.write(pq.isEmpty() ? "0" : String.valueOf(pq.poll()));
                bw.newLine();
            }
        }
        bw.flush();
    }
}
