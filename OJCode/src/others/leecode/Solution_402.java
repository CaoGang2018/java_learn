package others.leecode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/8/27 16:17
 */
public class Solution_402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            while(k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peekLast()){
                stack.pollLast();
                k--;
            }
            stack.offerLast(num.charAt(i));
        }
        while(k > 0){
            stack.pollLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peekFirst() == '0'){
            stack.pollFirst();
        }
        if(stack.isEmpty()) return "0";
        while (!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
}
