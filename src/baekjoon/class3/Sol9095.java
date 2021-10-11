package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] nums = getNums();

        StringBuilder out = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            out.append(nums[n]).append('\n');
        }

        System.out.println(out);
    }

    private static int[] getNums() {
        // 0 ~ 10
        int[] nums = new int[11];
        // nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3]
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        for (int i = 4; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        return nums;
    }
}
