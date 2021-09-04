package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol1001 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] words = bf.readLine().split("\\s+");
        System.out.println(Integer.parseInt(words[0]) - Integer.parseInt(words[1]));
    }
}
