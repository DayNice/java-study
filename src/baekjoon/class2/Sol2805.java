package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2805 {
    public static void main(String[] args) throws IOException {
        // get n, m, data
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] data = getData(new StringTokenizer(br.readLine()));

        // binary search
        int out = getBestLength(n, m, data);

        System.out.println(out);
    }

    private static int getBestLength(int n, int m, int[] data) {
        int first = 0, last = getMax(data);
        while (first <= last) {
            int middle = (first + last) / 2;
            if (getSum(data, middle) >= m) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }
        }
        return first - 1;
    }

    private static int getMax(int[] data) {
        int maxVal = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > maxVal) {
                maxVal = data[i];
            }
        }
        return maxVal;
    }

    private static long getSum(int[] data, int ref) {
        long total = 0;
        for (int datum : data) {
            if (datum > ref) {
                total += datum - ref;
            }
        }
        return total;
    }

    private static int[] getData(StringTokenizer st) {
        int length = st.countTokens();
        int[] data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        return data;
    }
}
