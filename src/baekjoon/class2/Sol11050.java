package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int out = getNum(n, k);

        System.out.println(out);
    }

    private static int getNum(int n, int k) {
        int out = 1;
        for (int i = n; i > n - k; i--) {
            out *= i;
        }
        for (int i = k; i > 0; i--) {
            out /= i;
        }
        return out;
    }

    private static int getNum_alt(int n, int k) {
        int[][] nums = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i][0] = nums[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
            }
        }
        return nums[n][k];
    }
}
