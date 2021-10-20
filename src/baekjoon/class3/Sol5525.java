package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String w = br.readLine();
        int count = w.charAt(0) == 'I' ? 1 : 0;
        int num = 0;
        for (int i = 1; i < m; i++) {
            if (w.charAt(i - 1) != w.charAt(i)) {
                count++;
            } else {
                count = (count - 1) / 2;
                num += Math.max(count - n + 1, 0);
                count = w.charAt(i) == 'I' ? 1 : 0;
            }
        }
        count = (count - 1) / 2;
        num += Math.max(count - n + 1, 0);

        System.out.println(num);
    }

    public static void main_alt(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] letters = br.readLine().toCharArray();

        int num = 0;
        int count = 0;
        for (int i = 2; i < m; i++) {
            if (letters[i - 2] == 'I' && letters[i - 1] == 'O' && letters[i] == 'I') {
                count++;
                i += 2;
            } else {
                count = 0;
            }
            if (count >= n) {
                num++;
            }
        }
        System.out.println(num);
    }
}
