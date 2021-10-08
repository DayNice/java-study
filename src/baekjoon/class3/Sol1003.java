package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[][] nums = getNums();
        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            out.append(nums[n][0]).append(' ').append(nums[n][1]).append('\n');
        }

        System.out.println(out);
    }

    private static int[][] getNums() {
        // 0 ~ 40
        int[][] nums = new int[41][2];
        nums[0][0] = 1;
        nums[1][1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i][0] = nums[i - 1][0] + nums[i - 2][0];
            nums[i][1] = nums[i - 1][1] + nums[i - 2][1];
        }
        return nums;
    }
}
