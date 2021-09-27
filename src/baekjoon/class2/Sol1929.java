package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isPrime = getIsPrime(n);

        StringBuilder out = new StringBuilder();
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                out.append(i).append('\n');
            }
        }

        System.out.println(out);
    }

    private static boolean[] getIsPrime(int n) {
        // 0 ~ n
        boolean[] isPrime = new boolean[n + 1];
        if (n >= 2) isPrime[2] = true;
        for (int i = 3; i <= n; i += 2) {
            isPrime[i] = true;
        }

        int limit = (int) Math.sqrt(n);
        for (int i = 3; i <= limit; i += 2) {
            if (isPrime[i]) {
                for (int j = i * 2; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
