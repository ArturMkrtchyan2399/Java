package Lesson13;


import java.util.Stack;

public class Expression {
    public static void main(String[] args) {
        System.out.println(check("[[[][]"));
        System.out.println(check("[[[]]]"));
        System.out.println(check("{}[]{}{}[]]"));
        System.out.println(check("[{[]}]"));
    }

    static boolean check(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.peek();
                if (top == '(' && ch == ')' || top == '{' && ch == '}' || top == '[' && ch == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
