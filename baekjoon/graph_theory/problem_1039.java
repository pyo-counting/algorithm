package baekjoon.graph_theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_1039 {
    public static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        StringBuffer N = new StringBuffer(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        result = Integer.parseInt(N.toString());

        DFS(N, 1, 1, K + 1);
        System.out.println(result);
    }

    public static void DFS(StringBuffer number, int i, int j, int k) {
        if(k == 0)
            return;

        char temp = number.charAt(i - 1);
        number.setCharAt(i - 1, number.charAt(j - 1));
        number.setCharAt(j - 1, temp);

        if(Integer.parseInt(number.toString()) > result) {
            result = Integer.parseInt(number.toString());
            System.out.println(result);
        }

        for(int J = i + 1; J < number.length(); J++){
            for(int I = i; I < J; I++){
                System.out.println(I + " " + J + " " + k);
                DFS(number, I, J, k - 1);
            }
        }
    }
}
