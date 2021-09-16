package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = getNums(br.readLine());
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();

        while (!Arrays.equals(nums, new int[]{0, 0, 0})) {
            if (nums[0] * nums[0] + nums[1] * nums[1] == nums[2] * nums[2]) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
            nums = getNums(br.readLine());
            Arrays.sort(nums);
        }

        System.out.println(sb);
    }

    public static int[] getNums(String line) {
        StringTokenizer st = new StringTokenizer(line);
        int length = st.countTokens();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        return nums;
    }
}
