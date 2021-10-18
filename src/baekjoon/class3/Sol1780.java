package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1780 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] nums = new int[3];
        setNums(nums, data, n, 0, 0);
        for (int x : nums) {
            System.out.println(x);
        }
    }

    private static void setNums(int[] nums, int[][] data, int n, int x, int y) {
        if (check(data, n, x, y)) {
            int color = data[x][y] + 1;
            nums[color] += 1;
            return;
        }
        n /= 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                setNums(nums, data, n, x + i * n, y + j * n);
            }
        }
    }

    private static boolean check(int[][] data, int n, int x, int y) {
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (data[i][j] != data[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
