package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[8];
        for (int i = 0; i < 8; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int diff = nums[1] - nums[0];
        String result = (diff > 0) ? "ascending" : "descending";
        for (int i = 2; i < 8; i++) {
            if (nums[i] - nums[i - 1] != diff) {
                result = "mixed";
                break;
            }
        }
        System.out.println(result);
    }
}
