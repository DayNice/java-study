package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i][0] > nums[j][0] && nums[i][1] > nums[j][1]) {
                    ranks[j]++;
                } else if (nums[i][0] < nums[j][0] && nums[i][1] < nums[j][1]) {
                    ranks[i]++;
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int rank : ranks) {
            out.append(rank + 1).append(" ");
        }

        System.out.println(out);
    }
}
