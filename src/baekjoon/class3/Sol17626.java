package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 0 ~ n
        int[] nums = new int[n + 1];
        Arrays.fill(nums, 4);
        nums[0] = 0;

        for (int i = 1; i <= n; i++) {
            int limit = (int) Math.sqrt(i);
            for (int j = 1; j <= limit; j++) {
                nums[i] = Math.min(nums[i], nums[i - j * j] + 1);
            }
        }

        System.out.println(nums[n]);
    }

    public static void main_alt(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // square numbers
        Set<Integer> setA = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            setA.add(i * i);
        }
        // residue
        Set<Integer> setB = new HashSet<>();
        for (Integer x : setA) {
            for (Integer y : setA) {
                setB.add(n - x - y);
            }
        }

        int out;
        if (setA.contains(n)) {
            out = 1;
        } else if (setB.contains(0)) {
            out = 2;
        } else {
            setB.retainAll(setA);
            if (!setB.isEmpty()) {
                out = 3;
            } else {
                out = 4;
            }
        }

        System.out.println(out);
    }
}
