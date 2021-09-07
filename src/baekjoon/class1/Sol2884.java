package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("\\s+");
        int minutes = Integer.parseInt(words[0]) * 60 + Integer.parseInt(words[1]) - 45;
        minutes = Math.floorMod(minutes, 60 * 24);
        System.out.printf("%d %d\n", minutes / 60, minutes % 60);
    }
}
