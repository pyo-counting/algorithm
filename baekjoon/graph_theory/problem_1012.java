package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem_1012 {

    static int arr[][];
    static Set<String> notVisited;
    static int bug;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfTest = Integer.parseInt(reader.readLine());

        for (; numOfTest > 0; numOfTest--) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            bug = 0;

            arr = new int[M][N];
            notVisited = new HashSet<>();

            for (; K > 0; K--) {
                String str = reader.readLine();
                st = new StringTokenizer(str, " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[X][Y] = 1;
                notVisited.add(str);
            }
            while (!notVisited.isEmpty()) {
                st = new StringTokenizer(notVisited.iterator().next(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                DFS(X, Y);
                bug++;
            }
            System.out.println(bug);
        }

    }

    public static void DFS(int x, int y) {
        arr[x][y] = 0;
        notVisited.remove(x + " " + y);

        if ((x - 1) >= 0 && arr[x - 1][y] == 1)
            DFS(x - 1, y);
        if ((x + 1) < arr.length && arr[x + 1][y] == 1)
            DFS(x + 1, y);
        if ((y - 1) >= 0 && arr[x][y - 1] == 1)
            DFS(x, y - 1);
        if ((y + 1) < arr[0].length && arr[x][y + 1] == 1)
            DFS(x, y + 1);
    }

}
