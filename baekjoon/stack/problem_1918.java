package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * example) 4*(1*3+(2+4)+1) =>
 * - 숫자는 결과 문자열에 append
 * - 연산자는 stack에 push
 * - stack이 비었을 경우 무조건 push
 * - 여는 괄호는 무조건 push
 * - stack이 비어있지 않을 경우 연산자 우선순위 비교(우선순위가 낮은 연산자, 같은 연산자일 경우에는 나주에 들어온 연산자를 stack에 보관)
 * - 닫는 괄호는 스택에서 여는 괄호 나올때까지 pop 및 결과 문자열에 append
 * - 마지막에 stack에서 모두 꺼내서 결과 문자열에 append
 */

public class problem_1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuffer result = new StringBuffer(str.length());

        for (int index = 0; index < str.length(); index++) {
            char ch = str.charAt(index);

            if (ch == '(' || ch == ')') {
                if (ch == '(')
                    stack.push(ch);
                else {
                    for (char c = stack.pop(); c != '('; c = stack.pop()) {
                        result.append(c);
                    }
                }
            } else if (ch == '*' || ch == '+' || ch == '-' || ch == '/') {
                if (stack.empty())
                    stack.push(ch);
                else if (stack.peek() == '(') {
                    stack.push(ch);
                } else {
                    if (ch == '+' || ch == '-') {
                        while (!stack.empty() && stack.peek() != '(') {
                            result.append(stack.pop());
                        }
                        stack.push(ch);
                    } else {
                        while (!stack.empty() && stack.peek() != '(' && stack.peek() != '-' && stack.peek() != '+') {
                            result.append(stack.pop());
                        }
                        stack.push(ch);
                    }
                }
            } else {
                result.append(ch);
            }
        }
        while (!stack.empty())
            result.append(stack.pop());

        System.out.println(result);
    }
}

