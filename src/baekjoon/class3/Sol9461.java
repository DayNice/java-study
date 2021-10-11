package baekjoon.class3;

import java.io.*;

public class Sol9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] nums = getNums();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String out = String.valueOf(nums[n]);
            bw.write(out);
            bw.newLine();
        }
        bw.flush();
    }

    private static long[] getNums() {
        // 0 ~ 100
        long[] nums = new long[101];
        // nums[i] = nums[i - 1] + nums[i - 5]
        nums[1] = nums[2] = nums[3] = 1;
        nums[4] = nums[5] = 2;
        for (int i = 6; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i - 5];
        }
        return nums;
    }
}
