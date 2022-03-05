package baekjoon.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem_7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        HashSet<String> set = new HashSet<>();

        while(n-- != 0){
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            String name = st.nextToken();
            if (st.nextToken().equals("enter"))
                set.add(name);
            else
                set.remove(name);
        }
        ArrayList<String> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        for(int i = sorted.size() - 1; i >=0; i --)
            System.out.println(sorted.get(i));
    }
}
