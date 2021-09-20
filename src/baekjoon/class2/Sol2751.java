package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sol2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        while (n-- > 0) {
            nums[n] = Integer.parseInt(br.readLine());
        }

        String out = Arrays.stream(nums).sorted().mapToObj(String::valueOf).collect(Collectors.joining("\n"));

        System.out.println(out);
    }

    public static void main_alt(String[] args) throws IOException {
        // faster, memory efficient
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // range -1_000_000 ~ 1_000_000
        boolean[] contains = new boolean[2_000_001];
        while (n-- > 0) {
            contains[Integer.parseInt(br.readLine()) + 1_000_000] = true;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 2_000_001; i++) {
            if (contains[i]) {
                out.append(i - 1_000_000).append("\n");
            }
        }

        System.out.println(out);
    }
}
