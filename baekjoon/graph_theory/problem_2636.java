package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 치즈 녹이는데 걸리는 시간과 모두 녹기 1시간 전 치즈 개수 출력하기
 * - 치즈 녹이는 시간:     DFS() 호출 횟수
 * - 1시간 전 치즈 개수:   각 시간마다 녹는 치즈 회수를 따로 계산하기
 */
public class problem_2636 {
    public static int[][] arr;
    public static boolean[][] isVisited;
    public static int meltedCheese = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        int totalCheese = 0;
        int totalHours = 0;

        for (int y = 0; y < arr.length; y++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int x = 0; x < arr[0].length; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                if (arr[y][x] == 1)
                    totalCheese++;
            }
        }
        do {
            meltedCheese = 0;
            isVisited = new boolean[arr.length][arr[0].length];

            dfs(0, 0);
            totalHours++;
            totalCheese -= meltedCheese;
        } while (totalCheese != 0);
        System.out.println(totalHours);
        System.out.println(meltedCheese);

    }

    public static void dfs(int x, int y) {
        if(x < 0 || x >= arr.length || y < 0 || y >= arr[0].length || isVisited[x][y])
            return;
        isVisited[x][y]= true;

        if(arr[x][y] == 1) {
            arr[x][y] = 0;
            meltedCheese++;
            return;
        }
        dfs(x-1, y);
        dfs(x+1, y);
        dfs(x, y-1);
        dfs(x, y+1);

    }
}
