package baekjoon.class3;

import java.io.*;
import java.util.StringTokenizer;

public class Sol11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean[][] adjMatrix = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = st.nextToken().equals("1");
            }
        }
        setAdjMatrix(n, adjMatrix);
        for (int i = 0; i < n; i++) {
            bw.write(adjMatrix[i][0] ? "1" : "0");
            for (int j = 1; j < n; j++) {
                bw.write(adjMatrix[i][j] ? " 1" : " 0");
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static void setAdjMatrix(int n, boolean[][] adjMatrix) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjMatrix[i][k] && adjMatrix[k][j]) adjMatrix[i][j] = true;
                }
            }
        }
    }
}
