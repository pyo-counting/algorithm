package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem_1010 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            dp = new int[N + 1][M + 1];
            System.out.println(bridge(N, M));
        }
    }

    public static int bridge(int N, int M) {

        if (dp[N][M] != 0)
            return dp[N][M];

        // 계산 안했던 경우
        if (N == M) {
            dp[N][M] = 1;
            return 1;
        } else if (N == 1) {
            dp[N][M] = M;
            return M;
        } else {
            int result = 0;

            for (int m = M - 1; m >= N - 1; m--)
                result += bridge(N - 1, m);

            dp[N][M] = result;
            return result;
        }
    }
}
