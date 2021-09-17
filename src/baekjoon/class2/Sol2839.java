package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sol2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int out = getNum(n);

        System.out.println(out);
    }

    private static int getNum(int n) {
        final int INF = Integer.MAX_VALUE;

        int[] nums = new int[Math.max(n + 1, 6)];
        Arrays.fill(nums, INF);
        nums[0] = 0;
        nums[3] = nums[5] = 1;

        for (int i = 6; i <= n; i++) {
            nums[i] = Math.min(nums[i - 3], nums[i - 5]);
            if (nums[i] != INF) {
                nums[i] += 1;
            }
        }

        int out = nums[n];
        if (out == INF) {
            out = -1;
        }
        return out;
    }

    private static int getNum_alt(int n) {
        int r = n % 5;
        while (r <= n) {
            if (r % 3 == 0) {
                return (n - r) / 5 + r / 3;
            }
            r += 5;
        }
        return -1;
    }
}
