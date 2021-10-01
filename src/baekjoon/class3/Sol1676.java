package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Sol1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger currentNum = BigInteger.ONE;
        while (n > 0) {
            currentNum = currentNum.multiply(BigInteger.valueOf(n));
            n--;
        }

        int count = 0;
        while (currentNum.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            currentNum = currentNum.divide(BigInteger.TEN);
            count++;
        }

        System.out.println(count);
    }

    public static void main_alt(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // count how many times 5 is multiplied into n!
        // (multiples of 5) + (multiples of 25) + (multiples of 125) + ..
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }

        System.out.println(count);
    }
}
