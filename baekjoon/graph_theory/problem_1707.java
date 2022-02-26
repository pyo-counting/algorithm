import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - 탐색하면서 그룹에 번갈아 가면서 분배
 *  => 그룹에 탐색한 정점을 추가할 떄 해당 간선이 있는 정점이 그룹에 이미 있을 경우 fail
 * - 간선 연결이 없는 정점이 있을 수 있음
 *  => 모든 정점
 */
public class problem_1707 {

    public static char[] isVisited;
    public static int[][] graph;
    public static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        int K,V,E;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(reader.readLine());

        while(K-- != 0){
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new int[V][V];
            isVisited = new char[V];
            isBipartite = true;

            while(E-- != 0){
                st = new StringTokenizer(reader.readLine(), " ");
                int fromVertex = Integer.parseInt(st.nextToken()) - 1;
                int toVertex = Integer.parseInt(st.nextToken()) - 1;
                graph[fromVertex][toVertex] = 1;
                graph[toVertex][fromVertex] = 1;
            }

            for(int i = 0; i < graph.length; i++){
                if(isVisited[i] == 0){
                    isVisited[i] = 'A';
                    BFS(i);
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }

    }

    public static void BFS(int initVertex){
        Queue<Integer> q = new LinkedList<>();
        q.offer(initVertex);

        while(!q.isEmpty()){
            int fromVertex = q.poll();

            for(int toVertex = 0; toVertex < isVisited.length; toVertex++){
                if(graph[fromVertex][toVertex] == 1 && isVisited[toVertex] != 0 && isVisited[toVertex] == isVisited[fromVertex]) {
                    isBipartite = false;
                    return;
                }
            }

            for(int toVertex = 0; toVertex < isVisited.length; toVertex++){
                if(isVisited[toVertex] == 0 && graph[fromVertex][toVertex] == 1 ){
                    q.offer(toVertex);
                    switch(isVisited[fromVertex]){
                        case 'A':
                            isVisited[toVertex] = 'B';
                            break;
                        case 'B':
                            isVisited[toVertex] = 'A';
                    }
                }
            }
        }

    }
}
