package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/9/2 20:19
 */
public class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        int c = 0;
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();
            size--;
            temp.add(t.val);
            if(t.left != null){
                queue.offer(t.left);
                c++;
            }
            if(t.right != null) {
                queue.offer(t.right);
                c++;
            }
            if(size == 0){
                ans.add(new ArrayList<>(temp));
                size = c;
                c = 0;
                temp.clear();
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if(i % 2 == 1)
                Collections.reverse(ans.get(i));
        }
        return ans;
    }
}
