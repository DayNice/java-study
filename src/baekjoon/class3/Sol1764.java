package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Sol1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> setA = new HashSet<>();
        Set<String> setB = new HashSet<>();

        for (int i = 0; i < n; i++) {
            setA.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            setB.add(br.readLine());
        }
        Set<String> setC = new HashSet<>(setA);
        setC.retainAll(setB);

        System.out.println(setC.size());
        String out = setC.stream().sorted().map(String::valueOf).collect(Collectors.joining("\n"));
        System.out.println(out);
    }
}
