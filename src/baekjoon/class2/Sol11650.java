package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sol11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums, Comparator.comparingInt((int[] x) -> x[0]).thenComparingInt((x) -> x[1]));

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(nums[i][0]).append(" ").append(nums[i][1]).append("\n");
        }

        System.out.println(out);
    }
}
