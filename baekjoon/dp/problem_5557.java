package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class problem_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] num = new int[n];
        long[] cache = new long[21];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        for (int idx = 0; idx < n - 1; idx++) {
            num[idx] = Integer.parseInt(st.nextToken());

            if (idx != 0) {
                long[] cache2 = new long[21];

                for (int idx2 = 0; idx2 < cache.length; idx2++) {
                    if (cache[idx2] != 0) {
                        if (cache[idx2] - num[idx] >= 0)
                            cache2[(int) cache[idx2] - num[idx]] = cache[idx2] + 1;
                        if (cache[idx2] + num[idx] <= 20)
                            cache2[(int) cache[idx2] + num[idx]] = cache[idx2] + 1;
                    }
                }
                cache = cache2;
            } else
                cache[num[idx]] += 1;
        }
        System.out.println(cache[Integer.parseInt(st.nextToken())]);


    }
}
