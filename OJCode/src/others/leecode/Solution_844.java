package others.leecode;

import java.util.Stack;

/**
 * @author admin_cg
 * @data 2020/10/19 14:12
 */
public class Solution_844 {
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }
    private String helper(String s){
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#'){
                stack.append(s.charAt(i));
            } else {
                if (stack.length() > 0){
                    stack.deleteCharAt(stack.length() - 1);
                }
            }
        }
        return stack.toString();
    }

    private boolean doubleCheck(String S, String T) {


        return true;
    }
}
