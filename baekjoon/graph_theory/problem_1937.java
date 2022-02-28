package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대나무가 숲의 크기 n x n
 * 판다는 있던 곳 보다 대나무가 많은 곳으로만 이동
 * 판다가 최대한 많은 칸을 이동할 횟수를 출력
 * <p>
 * - (0, 0) ~ (n, n)을 시작점으로하면서 이동 횟수를 갱신
 */

public class problem_1937 {

    public static int n;
    public static int[][] graph;
    public static int result;
    public static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        graph = new int[n][n];

        for (int index1 = 0; index1 < n; index1++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int index2 = 0; index2 < n; index2++)
                graph[index1][index2] = Integer.parseInt(st.nextToken());
        }

        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = 0; index2 < n; index2++) {
                isVisited = new boolean[n];
                DFS(index1, index2, 0);
            }
        }
        System.out.println(result);
    }

    public static void DFS(int x, int y, int count) {
        if (++count > result)
            result = count;

        if (x - 1 >= 0 && (graph[x][y] < graph[x - 1][y]))
            DFS(x - 1, y, count);
        if (x + 1 < graph.length && (graph[x][y]) < graph[x + 1][y])
            DFS(x + 1, y, count);
        if (y - 1 >= 0 && (graph[x][y] < graph[x][y - 1]))
            DFS(x, y - 1, count);
        if (y + 1 < graph.length && (graph[x][y] < graph[x][y + 1]))
            DFS(x, y + 1, count);
    }
}
