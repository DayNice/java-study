package baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sol2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.remove();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }

    public static void main_alt(String[] args) throws IOException {
        // faster, memory efficient
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n * 2];

        for (int i = 0; i <= n - 1; i++) {
            nums[i] = i + 1;
        }

        int first = 0;
        int last = n - 1;
        while (first < last) {
            first++;
            nums[++last] = nums[first++];
        }

        System.out.println(nums[first]);
    }
}
