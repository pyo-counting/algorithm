package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] arr = new long[n + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int N = 2; N <= n; N++)
            arr[N] = (arr[N - 1] + arr[N - 2]) % 10007;

        System.out.println(arr[n]);

    }
}
