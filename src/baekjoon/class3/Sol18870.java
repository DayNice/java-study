package baekjoon.class3;

import java.io.*;
import java.util.*;

public class Sol18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Integer> data = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>(new HashSet<>(data));
        keys.sort(null);
        for (Integer key : keys) {
            map.put(key, count);
            count++;
        }

        for (Integer x : data) {
            bw.write(map.get(x).toString());
            bw.write(' ');
        }
        bw.flush();
    }

    public static void main_alt(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] xPoint = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            xPoint[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmp = Arrays.copyOf(xPoint, n);
        Arrays.sort(tmp);
        int[] keys = new int[n];
        keys[0] = tmp[0];
        int currentIndex = 0;
        for (int x : tmp) {
            if (x == keys[currentIndex]) continue;
            currentIndex++;
            keys[currentIndex] = x;
        }

        for (Integer x : xPoint) {
            bw.write(Arrays.binarySearch(keys, 0, currentIndex + 1, x) + " ");
        }
        bw.flush();
    }
}
