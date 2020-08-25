package others.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/8/19 18:46
 */
public class Solution_22 {
    public static void main(String[] args) {
        Solution_22 ss = new Solution_22();
        //char[] d = new char[]{'1', '2', '3', '4'};
        String d = "1234";
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        orderList(stack, "", d);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(ans, sb, 0, 0, n);
        return ans;

    }
    public List<String> generateParenthesis1(char[] t) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        return ans;

    }
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if(cur.length() == max * 2){
            ans.add(cur.toString());
            return;
        }
        if(open < max){
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if(close < open){
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static void orderList(Stack<String> stack,String result,String input){
        //利用对象克隆的方法，先把栈复制下来以免操作后影响下面
        Stack<String> temp=(Stack<String>)stack.clone();
        String subStr=input.substring(0,1);
        input=input.substring(1);
        temp.push(subStr);
        if(input.length()==0){
            while(!temp.isEmpty()){
                result += temp.pop().toString();
            }
            System.out.println(result);
        }
        else{
            orderList(temp,result,input);
            while(!temp.isEmpty()){
                result+=temp.pop();
                orderList(temp,result,input);
            }
        }
    }
}
