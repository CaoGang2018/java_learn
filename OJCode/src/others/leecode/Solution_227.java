package others.leecode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/9/2 10:15
 */
public class Solution_227 {
    public static void main(String[] args) {
        Solution_227 ss = new Solution_227();
        String s2 = "2*3+4";
        System.out.println(ss.calculate(s2));
    }
    public int calculate(String s) {
        if(s.length() == 0)
            return 0;
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()){
            if(s.charAt(i) == '+' ||s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/' ){
                stack.offerLast(s.charAt(i));
                i++;
            }
            int temp = 0;
            while (i < s.length()){
                if(s.charAt(i) == '+' ||s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/')
                    break;
                else if(s.charAt(i) != ' ')
                    temp = temp*10 + s.charAt(i) - '0';
                i++;
            }
            numStack.offerLast(temp);

            if(!stack.isEmpty()){
                if(stack.peekLast() == '*'){
                    numStack.offerLast(numStack.pollLast() * numStack.pollLast());
                    stack.pollLast();
                }
                else if(stack.peekLast() == '/'){
                    int t = numStack.pollLast();
                    numStack.offerLast(numStack.pollLast() / t);
                    stack.pollLast();
                }
            }
        }
        while (!stack.isEmpty()){
            if (stack.peekFirst() == '-'){
                int t1 = numStack.pollFirst();
                int t2 = numStack.pollFirst();
                numStack.offerFirst(t1-t2);
            }
            else {
                numStack.offerFirst(numStack.pollFirst() + numStack.pollFirst());
            }
            stack.pollFirst();
        }
        return numStack.peekFirst();
    }
}
