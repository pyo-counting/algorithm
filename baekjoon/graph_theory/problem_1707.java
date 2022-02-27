import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * - 탐색하면서 그룹('A', 'B')에 번갈아 가면서 분배
 * => 그룹에 탐색한 정점을 추가할 떄 인접한 정점이 해당 그룹에 이미 있을 경우 fail
 * - 간선 연결이 없는 정점의 그룹이 있을 수 있음
 * => 모든 정점에 대해 위 그룹 분배를 수행하도록 처리
 */
public class problem_1707 {

    public static char[] isVisited;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        int K, V, E;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(reader.readLine());

        while (K-- != 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>(V);
            for (int index = 0; index < V; index++)
                graph.add(index, new ArrayList<Integer>());
            isVisited = new char[V];
            isBipartite = true;

            while (E-- != 0) {
                st = new StringTokenizer(reader.readLine(), " ");
                int fromVertex = Integer.parseInt(st.nextToken()) - 1;
                int toVertex = Integer.parseInt(st.nextToken()) - 1;
                graph.get(fromVertex).add(toVertex);
                graph.get(toVertex).add(fromVertex);
            }

            /**
             * - 간선 연결이 없는 정점의 그룹이 있을 수 있음
             * => 모든 정점에 대해 위 그룹 분배를 수행하도록 처리
             */
            for (int i = 0; i < graph.size(); i++) {
                if (isBipartite && isVisited[i] == 0) {
                    isVisited[i] = 'A';
                    DFS(i);
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    public static void DFS(int fromVertex) {
        if (!isBipartite)
            return;

        /**
         * - 탐색하면서 그룹('A', 'B')에 번갈아 가면서 분배
         * => 그룹에 탐색한 정점을 추가할 떄 인접한 정점이 해당 그룹에 이미 있을 경우 fail
         */
        for (int toVertex : graph.get(fromVertex)) {
            if (isVisited[toVertex] != 0 && isVisited[fromVertex] == isVisited[toVertex]) {
                isBipartite = false;
                return;
            }
        }

        for (int toVertex : graph.get(fromVertex)) {
            if (!isBipartite)
                return;
            if (isVisited[toVertex] == 0) {
                switch (isVisited[fromVertex]) {
                    case 'A':
                        isVisited[toVertex] = 'B';
                        break;
                    case 'B':
                        isVisited[toVertex] = 'A';
                }
                DFS(toVertex);
            }
        }
    }
}
