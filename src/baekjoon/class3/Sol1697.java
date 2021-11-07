package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(getCount(n, k));
    }

    private static int getCount(int n, int k) {
        if (n > k) {
            return n - k;
        }
        int answer = -1;
        Queue<Integer[]> queue = new LinkedList<>();
        // (position, count)
        queue.add(new Integer[]{n, 0});
        // 0 ~ 2 * k
        boolean[] visited = new boolean[2 * k + 1];
        while (!queue.isEmpty()) {
            Integer[] v = queue.poll();
            if (v[0] < 0 || v[0] > 2 * k || visited[v[0]]) {
                continue;
            }
            if (v[0] == k) {
                answer = v[1];
                break;
            }
            visited[v[0]] = true;
            queue.add(new Integer[]{2 * v[0], v[1] + 1});
            queue.add(new Integer[]{v[0] - 1, v[1] + 1});
            queue.add(new Integer[]{v[0] + 1, v[1] + 1});
        }
        return answer;
    }

    private static int getCount_alt(int n, int k) {
        if (n > k) {
            return n - k;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int[] time = new int[2 * k + 1];
        Arrays.fill(time, -1);
        time[n] = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == k) {
                break;
            }
            if (v > 0 && time[v - 1] == -1) {
                time[v - 1] = time[v] + 1;
                queue.add(v - 1);
            }
            if (v < 2 * k && time[v + 1] == -1) {
                time[v + 1] = time[v] + 1;
                queue.add(v + 1);
            }
            if (v <= k && time[2 * v] == -1) {
                time[2 * v] = time[v] + 1;
                queue.add(2 * v);
            }
        }
        return time[k];
    }
}
