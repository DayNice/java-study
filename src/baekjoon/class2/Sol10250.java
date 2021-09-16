package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int[] nums = getNums(br.readLine());
            int y = (nums[2] - 1) % nums[0] + 1;
            int x = (nums[2] - 1) / nums[0] + 1;
            sb.append(y * 100 + x).append("\n");
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
