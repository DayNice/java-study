package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rewards = new int[n];
        for (int i = 0; i < n; i++) {
            rewards[i] = Integer.parseInt(br.readLine());
        }

        int out = getMaxGain(rewards);
        System.out.println(out);
    }

    private static int getMaxGain(int[] rewards) {
        int n = rewards.length;
        if (n == 1) {
            return rewards[0];
        }
        if (n == 2) {
            return rewards[0] + rewards[1];
        }

        int[][] nums = new int[n][2];
        // 0: can step one floor up
        // 1: already stepped one floor up
        nums[0][0] = nums[0][1] = rewards[0];
        nums[1][0] = rewards[1];
        nums[1][1] = nums[0][0] + rewards[1];
        for (int i = 2; i < rewards.length; i++) {
            nums[i][0] = Math.max(nums[i - 2][0], nums[i - 2][1]) + rewards[i];
            nums[i][1] = nums[i - 1][0] + rewards[i];
        }
        return Math.max(nums[n - 1][0], nums[n - 1][1]);
    }
}
