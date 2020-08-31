package others.leecode;

import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/8/28 12:48
 */
public class Solution_150 {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int t = stack.pop() + stack.pop();
                stack.push(t);
            } else if (token.equals("-")) {
                int o = stack.pop();
                int t = stack.pop() - o;
                stack.push(t);
            } else if (token.equals("*")) {
                int t = stack.pop() * stack.pop();
                stack.push(t);
            } else if (token.equals("/")) {
                int o = stack.pop();
                int t = stack.pop() / o;
                stack.push(t);
            } else stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
