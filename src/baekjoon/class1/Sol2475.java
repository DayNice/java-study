package baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sol2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int total = 0;
        for(String w : bf.readLine().split("\\s+")){
            total += (int)Math.pow(Integer.parseInt(w), 2);
        }
        System.out.println(total % 10);
    }
}
