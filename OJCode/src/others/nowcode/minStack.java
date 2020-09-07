package others.nowcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author admin_cg
 * @date 2020/9/5 19:47
 */
public class minStack {
    public int[] getMinStack (int[][] op) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        int min = -1;
        for(int[] o : op){
            switch (o[0]){
                case 1:
                    if(stack.isEmpty()){
                        stack.push(0);
                        min = o[1];
                    }
                    else{
                        int d = o[1] - min;
                        stack.push(d);
                        min = d > 0 ? min : o[1];
                    }
                    break;
                case 2:
                    int d = stack.pop();
                    if(d < 0){
                        //ans.add(min - d);
                        min -= d;
                    }
                    //else ans.add(min + d);
                    break;
                case 3:
                    ans.add(min);
                    break;

            }
        }
        int[] ansa = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansa[i] = ans.get(i);
        }
        return ansa;
    }
}
