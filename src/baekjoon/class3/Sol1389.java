package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1389 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] links = new boolean[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            // convert to zero-base
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            links[i][j] = links[j][i] = true;
        }

        int[] nums = getNums(n, links);
        int argMin = getArgMin(nums);
        System.out.println(argMin + 1);
    }

    private static int getArgMin(int[] nums) {
        int argMin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[argMin]) {
                argMin = i;
            }
        }
        return argMin;
    }

    private static int[] getNums(int n, boolean[][] links) {
        int[][] distance = getDistance(n, links);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && distance[i][j] < INF) {
                    nums[i] += distance[i][j];
                }
            }
        }
        return nums;
    }

    private static int[][] getDistance(int n, boolean[][] links) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = links[i][j] ? 1 : INF;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
        return distance;
    }
}
