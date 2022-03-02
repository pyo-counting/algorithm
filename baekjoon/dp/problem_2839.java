package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int arr[] = new int[N + 1];

        if (N >= 3) {
            arr[3] = 1;
            if (N >= 5) {
                arr[5] = 1;

                for (int n = 6; n <= N; n++) {
                    int x = (arr[n - 3] == 0) ? 0 : 1 + arr[n - 3];
                    int y = (arr[n - 5] == 0) ? 0 : 1 + arr[n - 5];

                    if(x != 0 && y != 0){
                        arr[n] = Math.min(x, y);
                    } else
                        arr[n] = x + y;
                }
            }
        }
        System.out.println(arr[N] == 0 ? -1 : arr[N]);
    }
}
