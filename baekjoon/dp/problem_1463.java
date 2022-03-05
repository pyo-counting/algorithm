package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem_1463 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n + 1];

        // 1) 2, 3 초기화
        if (n >= 2) {
            arr[2] = 1;
            if (n >= 3) {
                arr[3] = 1;
            }
        }

        for (int i = 4; i < arr.length; i++) {
            int tmp = 0;

            // 2) 3의 공배수일 경우 횟수 구하기
            if (i % 3 == 0)
                tmp = arr[i / 3] + 1;

            // 3) 2의 공배수일 경우 횟수 구해서 2)의 경우와 비교
            if ( i % 2 == 0)
                tmp = (tmp == 0 ? arr[i / 2] + 1 : Math.min(arr[i / 2] + 1, tmp));

            // 4) -1한 경우 횟수 구해서 2) or 3)의 경우와 비교
            tmp = (tmp == 0 ? arr[i - 1] + 1 : Math.min(arr[i - 1] + 1, tmp));
            arr[i] = tmp;
        }
        System.out.println(arr[n]);
    }
}
