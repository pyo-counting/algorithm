package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class problem_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            String input = reader.readLine();
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;

            for (int j = 0; j < input.length(); j++) {
                char a = input.charAt(j);

                if (a == '(') {
                    stack.push('(');
                } else if (a == ')') {
                    if(stack.isEmpty()) {
                        isValid=false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(isValid && stack.isEmpty()){
                System.out.println("YES");
            } else{
                System.out.println("NO");
            }
        }

    }
}
