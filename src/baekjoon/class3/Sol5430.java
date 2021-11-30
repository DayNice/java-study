package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Sol5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            bw.write(execute(p, n, line));
            bw.newLine();
        }
        bw.flush();
    }

    private static String execute(String p, int n, String line) {
        Deque<String> data = parseData(n, line);
        boolean reversed = false;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == 'R') {
                reversed = !reversed;
            } else if (c == 'D') {
                if (data.isEmpty()) {
                    return "error";
                }
                if (reversed) {
                    data.removeLast();
                } else {
                    data.removeFirst();
                }
            }
        }
        return printData(data, reversed);
    }

    private static Deque<String> parseData(int n, String line) {
        StringTokenizer st = new StringTokenizer(line, "[,]");
        Deque<String> data = new ArrayDeque<>(n);
        while (n-- > 0) {
            data.addLast(st.nextToken());
        }
        return data;
    }

    private static String printData(Deque<String> data, boolean reversed) {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (Iterator<String> it = reversed ? data.descendingIterator() : data.iterator(); it.hasNext(); ) {
            sj.add(it.next());
        }
        return sj.toString();
    }
}
