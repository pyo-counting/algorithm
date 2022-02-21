package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem_2504 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Stack<Character> stack = new Stack<>();
        int result, tmp = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '(' || c == '[')
                stack.push(c);
            else{


            }



        }
    }
}
