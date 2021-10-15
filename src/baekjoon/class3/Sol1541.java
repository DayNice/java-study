package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sol1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] blocks = br.readLine().split("-");
        int total = Arrays.stream(blocks[0].split("\\+")).mapToInt(Integer::parseInt).sum();
        for (int i = 1; i < blocks.length; i++) {
            total -= Arrays.stream(blocks[i].split("\\+")).mapToInt(Integer::parseInt).sum();
        }
        System.out.println(total);
    }

    public static void main_alt(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int total = getSum(st.nextToken());
        while (st.hasMoreTokens()) {
            total -= getSum(st.nextToken());
        }
        System.out.println(total);
    }

    private static int getSum(String line) {
        StringTokenizer st = new StringTokenizer(line, "+");
        int total = 0;
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }
        return total;
    }
}
