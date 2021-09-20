package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Sol10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][2];
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = i;
            words[i] = st.nextToken();
        }
        Arrays.sort(nums, Comparator.comparingInt((x) -> x[0]));

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(nums[i][0]).append(" ").append(words[nums[i][1]]).append("\n");
        }

        System.out.println(out);
    }

    public static void main_alt(String[] args) throws IOException {
        // slower
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = br.readLine();
        }

        Arrays.sort(lines, Comparator.comparingInt((x) -> Integer.parseInt(new StringTokenizer(x).nextToken())));

        System.out.println(String.join("\n", lines));
    }

    public static void main_alt2(String[] args) throws IOException {
        // faster
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder[] blocks = new StringBuilder[201];
        for (int i = 0; i < blocks.length; i++) {
            blocks[i] = new StringBuilder();
        }

        while (n-- > 0) {
            String line = br.readLine();
            int age = Integer.parseInt(new StringTokenizer(line).nextToken());
            blocks[age].append(line).append("\n");
        }

        StringBuilder out = new StringBuilder();
        for (StringBuilder sb : blocks) {
            out.append(sb);
        }

        System.out.println(out);
    }
}
