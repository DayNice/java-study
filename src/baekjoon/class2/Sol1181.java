package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Sol1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        while (n-- > 0) {
            set.add(br.readLine());
        }
        String[] words = set.toArray(new String[0]);
        Arrays.sort(words, Comparator.comparing(String::length).thenComparing(String::valueOf));

        System.out.println(String.join("\n", words));
    }
}
