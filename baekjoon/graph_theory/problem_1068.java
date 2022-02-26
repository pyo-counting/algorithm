package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * - 삭제 node == root node일 경우 0 출력 후 종료
 * - 삭제 node의 경우, 부모 node와의 간선 추가하지 않음
 */
public class problem_1068 {
    public static boolean[] isVisited;
    public static int[][] arr;
    public static int numOfNoP;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numOfNode = Integer.parseInt(reader.readLine());
        int rootNode = 0;
        arr = new int[numOfNode][numOfNode];
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int removeNode = Integer.parseInt(reader.readLine());

        for (int index = 0; index < arr.length; index++) {
            int pNode = Integer.parseInt(st.nextToken());

            // 삭제 node의 경우, 부모 node와의 간선 추가하지 않음
            if (index == removeNode)
                continue;

            if (pNode == -1) {
                rootNode = index;
                continue;
            }
            arr[index][pNode] = 1;
            arr[pNode][index] = 1;
        }

        // 삭제 node == root 노드일 경우 0 출력 후 종료
        if (rootNode == removeNode) {
            System.out.println(0);
            return;
        }

        isVisited = new boolean[arr.length];
        BFS(rootNode);
        System.out.println(numOfNoP);
    }

    public static void BFS(int initNode) {
        Queue<Integer> q = new LinkedList<>();

        isVisited[initNode] = true;
        q.offer(initNode);

        while (!q.isEmpty()) {
            int fromNode = q.poll();
            boolean hasChild = false;

            for (int toNode = 0; toNode < isVisited.length; toNode++) {
                if (!isVisited[toNode] && arr[fromNode][toNode] == 1) {
                    isVisited[toNode] = true;
                    q.offer(toNode);
                    hasChild = true;
                }
            }
            if (!hasChild)
                numOfNoP++;
        }

    }
}
