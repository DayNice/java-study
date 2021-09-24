package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] data = new int[k];
        for (int i = 0; i < k; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int out = findBestLength(data, n);
        System.out.println(out);
    }

    private static int findBestLength(int[] data, int n) {
        long first = 1;
        long last = getMax(data);

        while (first <= last) {
            long x = (first + last) / 2;
            long num = getNum(data, x);

            // anything before first is acceptable
            // anything after last is not acceptable
            // anything in between is a candidate
            if (num >= n) {
                first = x + 1;
            } else {
                last = x - 1;
            }
        }

        return (int) last;
    }

    private static long getNum(int[] data, long x) {
        long count = 0;
        for (int datum : data) {
            count += datum / x;
        }
        return count;
    }

    private static int getMax(int[] data) {
        int out = data[0];
        for (int datum : data) {
            if (datum > out) {
                out = datum;
            }
        }
        return out;
    }
}
