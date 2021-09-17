package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] nums = new int[15][15];
        for (int i = 0; i < 15; i++) {
            nums[0][i] = i;
            nums[i][0] = 0;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                nums[i][j] = nums[i][j - 1] + nums[i - 1][j];
            }
        }

        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(nums[k][n]);
        }
    }
}
