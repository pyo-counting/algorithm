package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem_2504 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int temp = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();

        // example:  (()[[]])([])
        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);

            if (ch == '(' || ch == '[') {
                stack.push(ch);
                if (ch == '(')
                    temp *= 2;
                else
                    temp *= 3;
            } else if (ch == ')' || ch == ']') {
                // 1) 괄호 짝이 맞는지 확인
                if (ch == ')' && (stack.empty() || stack.pop() != '(')) {
                    result = 0;
                    break;
                } else if (ch == ']' && (stack.empty() || stack.pop() != '[')) {
                    result = 0;
                    break;
                }
                
                // 2) 이전 괄호가 닫는 괄호가 아닐 경우에만 결과값에 더하기 실행
                if (!(str.charAt(index - 1) == ')' || str.charAt(index - 1) == ']')) {
                    result += temp;
                }

                if (ch == ')')
                    temp /= 2;
                else
                    temp /= 3;

            }
        }
        if (!stack.empty())
            result = 0;

        System.out.print(result);
    }
}

