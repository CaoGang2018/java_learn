package others.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author admin_cg
 * @date 2020/8/13 13:07
 */
public class Solution_1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> tp= new LinkedList<>();
        List<Integer> t = new ArrayList<>();
        int k = 1;
        tp.offer(root);
        while(!tp.isEmpty()){
            TreeNode t1 = tp.poll();
            k--;
            t.add(t1.val);
            if(t1.left != null){
                tp.offer(t1.left);
            }
            if(t1.right != null){
                tp.offer(t1.right);
            }
            if(k == 0 && tp.size() != 0){
                t.clear();
                k = tp.size();
            }
        }
        int ans = 0;
        for (Integer integer : t) {
            ans += integer;

        }
        return ans;
    }
}
