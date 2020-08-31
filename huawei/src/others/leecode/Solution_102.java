package others.leecode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author admin_cg
 * @date 2020/8/30 12:58
 */
public class Solution_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp = new LinkedList<>();
        int k = 1, c = 0;
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();
            temp.add(t.val);
            --k;
            if(t.left != null){
                queue.add(t.left);
                ++c;
            }
            if(t.right != null){
                queue.add(t.right);
                ++c;
            }
            if(k == 0){
                ans.add(new LinkedList<>(temp));
                temp.clear();
                k = c;
                c = 0;
            }
        }
        return ans;
    }
}
