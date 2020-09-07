package others.leecode;

import others.nowcode.Solution;

import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/8/26 15:44
 */
public class Solution_32 {
    public static void main(String[] args) {
        Solution_32 ss = new Solution_32();
        System.out.println(ss.longestValidParentheses("()(()"));
    }
    public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else ans = Math.max(ans, i-stack.peek());
            }
        }
        return ans;
    }
}
