package baekjoon.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Sol1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()) - 1;
        boolean[][] links = new boolean[n][n];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            links[i][j] = links[j][i] = true;
        }

        List<Integer> nums;
        nums = dfs(links, n, v);
        System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        nums = bfs(links, n, v);
        System.out.println(nums.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static List<Integer> dfs(boolean[][] links, int n, int v) {
        List<Integer> nums = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v);
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            nums.add(i + 1);
            for (int j = n - 1; j >= 0; j--) {
                if (links[i][j] && !visited[j]) {
                    stack.push(j);
                }
            }
        }
        return nums;
    }

    private static List<Integer> bfs(boolean[][] links, int n, int v) {
        List<Integer> nums = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            nums.add(i + 1);
            for (int j = 0; j < n; j++) {
                if (links[i][j] && !visited[j]) {
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        return nums;
    }
}
