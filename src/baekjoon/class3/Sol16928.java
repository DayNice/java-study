package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Sol16928 {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nm = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        // 0 ~ 100, initialize with portals[i] = i
        int[] portals = new int[101];
        Arrays.setAll(portals, (x) -> x);
        // set portals
        while (nm-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            portals[i] = j;
        }
        int out = getNum(portals);
        System.out.println(out);
    }

    private static int getNum(int[] portals) {
        int[] distances = new int[101];
        Arrays.fill(distances, INF);
        distances[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int y = x + i;
                if (y > 100) continue;
                y = portals[y];
                if (distances[y] == INF) {
                    distances[y] = distances[x] + 1;
                    queue.add(y);
                }
            }
        }
        return distances[100];
    }
}
