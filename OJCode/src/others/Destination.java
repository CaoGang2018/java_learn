package others;

import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/8/15 18:03
 */
public class Destination {
    public static void main(String[] args) {
        String[][] test = {{"beijing", "nanjing"}, {"nanjing", "guangzhou"}, {"guangzhou", "shanghai"}, {"shanghai", "beijing"}, {"fuzhou", "beijing"}, {"beijing", "fuzhou"}};
        System.out.println(toDestination(test));
    }

    public static int toDestination(String[][] str){
        if(str.length == 0) return  0;
        int count = 0;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length; i++){
            if(stack.isEmpty()){
                stack.push(str[i][0]);
                stack.push(str[i][1]);
            }
            else{
                if(str[i][0].equals(stack.peek())){
                    stack.pop();
                }
                if(str[i][1].equals(stack.peek())){
                    stack.pop();
                    count++;
                }
            }
        }
        return count;
    }
}
