package baekjoon.class3;

import java.io.*;
import java.util.PriorityQueue;

public class Sol11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int out = Math.abs(o1) - Math.abs(o2);
            if (out == 0) return o1 - o2;
            return out;
        });
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
