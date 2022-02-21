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
        DFS(N, K);
        System.out.println(result);
    }

    public static void DFS(StringBuffer number, int k) {
        if (k == 0) {
            if (Integer.parseInt(number.toString()) > result)
                result = Integer.parseInt(number.toString());
        } else {
            result = -1;
            for (int J = 1; J < number.length(); J++) {
                for (int I = 0; I < J; I++) {
                    StringBuffer changedNumber = new StringBuffer(number.toString());
                    char temp = changedNumber.charAt(I);
                    changedNumber.setCharAt(I, changedNumber.charAt(J));
                    changedNumber.setCharAt(J, temp);
                    if (changedNumber.charAt(0) != '0')
                        DFS(changedNumber, k - 1);
                }
            }
        }
    }
}


