package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sol1463 {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int out = getNum(n);
        System.out.println(out);
    }

    private static int getNum(int n) {
        if (n == 0) {
            // case (n < r): getNum(0) + n % r = n - 1
            return -2;
        } else if (n == 1) {
            return 0;
        }

        Integer x = cache.get(n);
        if (x != null) {
            return x;
        }
        x = Math.min(getNum(n / 3) + n % 3, getNum(n / 2) + n % 2) + 1;
        cache.put(n, x);
        return x;
    }
}
