package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[3];

        while(n-- != 0){
            int[] tmp = new int[3];
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            tmp[2] = Integer.parseInt(st.nextToken());

            tmp[0] += Math.min(arr[1], arr[2]);
            tmp[1] += Math.min(arr[0], arr[2]);
            tmp[2] += Math.min(arr[0], arr[1]);

            arr = tmp;
        }

        Arrays.sort(arr);
        System.out.println(arr[0]);
    }
}
