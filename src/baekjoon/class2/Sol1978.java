package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = getIsPrime();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while (n-- > 0) {
            if (isPrime[Integer.parseInt(st.nextToken())]) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean[] getIsPrime() {
        boolean[] isPrime = new boolean[1001];
        isPrime[2] = true;
        for (int i = 3; i < isPrime.length; i += 2) {
            isPrime[i] = true;
        }

        int limit = (int) Math.sqrt(isPrime.length);
        for (int i = 3; i <= limit; i += 2) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
