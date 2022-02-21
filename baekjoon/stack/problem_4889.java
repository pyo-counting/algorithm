package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem_4889 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numOfCase = 1;
        while (true) {
            String str = reader.readLine();
            if (str.startsWith("-"))
                break;

            Stack<Character> orgStack = new Stack<>();
            int changed = 0;
            for (int index = 0; index < str.length(); index++) {
                char ch = str.charAt(index);

                if (ch == '{')
                    orgStack.push(ch);
                else {
                    if (orgStack.isEmpty()) {
                        changed++;
                        orgStack.push('{');
                    } else {
                        orgStack.pop();
                    }
                }
            }
            changed += orgStack.size() / 2;
            System.out.println(numOfCase++ + ". " + changed);
        }
    }
}
