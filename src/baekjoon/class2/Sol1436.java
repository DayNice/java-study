package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sol1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        set.add(666);
        int digits = 1;
        while (set.size() < n) {
            int high = (int) Math.pow(10, digits);
            int low = (int) Math.pow(10, digits - 1);

            for (int i = 0; i < low; i++) {
                set.add(666 * high + i);
            }
            for (int i = low; i < high; i++) {
                int r = 1;
                for (int j = 0; j <= digits; j++) {
                    int x = i / r;
                    int y = i % r;
                    set.add(x * 1000 * r + 666 * r + y);
                    r *= 10;
                }
            }
            digits++;
        }
        Integer[] nums = set.toArray(new Integer[0]);
        Arrays.sort(nums);
        System.out.println(nums[n - 1]);
    }

    public static void main_alt(String[] args) throws IOException {
        // faster
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;
        while (count < n) {
            num++;
            int x = num;
            while (x > 100) {
                if (x % 1000 == 666) {
                    count++;
                    break;
                }
                x /= 10;
            }
        }

        System.out.println(num);
    }
}
