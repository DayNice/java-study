package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sol1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        int num = getNum(data, n);
        System.out.println(num);
    }

    private static int getNum(int[][] data, int n) {
        Arrays.sort(data, Comparator.comparingInt((int[] x) -> x[1]).thenComparingInt(x -> x[0]));
        int count = 1;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (data[i][1] <= data[j][0]) {
                count++;
                i = j;
            }
        }
        return count;
    }
}
