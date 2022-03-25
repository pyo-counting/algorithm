package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_2638 {

    public static int[][] graph;
    public static int[][] tmp;
    public static boolean[][] isVisited;
    public static int numOfCheese, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        graph = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];

        // 치즈 위치, 개수 저장
        for (int y = 0; y < graph.length; y++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int x = 0; x < graph[0].length; x++) {
                graph[y][x] = Integer.parseInt(st.nextToken());
                if (graph[y][x] == 1)
                    numOfCheese++;
            }
        }

        for (; numOfCheese != 0; count++) {
            isVisited = new boolean[graph.length][graph[0].length];
            tmp = new int[graph.length][graph[0].length];
            dfs(0, 0, count + 2);
        }
        System.out.println(count);
    }

    public static void dfs(int y, int x, int count) {

        if (graph[y][x] == 1) {
            tmp[y][x]++;
            if (tmp[y][x] >= 2) {
                graph[y][x] = count;
                numOfCheese--;
            }
        } else if (graph[y][x] < count) {
            isVisited[y][x] = true;

            if (y - 1 >= 0 && !isVisited[y - 1][x])
                dfs(y - 1, x, count);
            if (x - 1 >= 0 && !isVisited[y][x - 1])
                dfs(y, x - 1, count);
            if (y + 1 < graph.length && !isVisited[y + 1][x])
                dfs(y + 1, x, count);
            if (x + 1 < graph[0].length && !isVisited[y][x + 1])
                dfs(y, x + 1, count);
        }
    }

}

