package others.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin_cg
 * @date 2020/8/21 13:38
 */
public class Solution_111 {
    public int minDepth(TreeNode root){
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int k = 1, c = 1, t = 0;
        while(!q.isEmpty()){
            int tmp = 0;
            tmp = t;
            TreeNode p = q.poll();
            c--;
            if(p.left != null){
                q.offer(p.left);
                t++;
            }
            if(p.right != null){
                q.offer(p.right);
                t++;
            }
            if(tmp == t) return k;
            if(c == 0){
                k++;
                c = t;
                t = 0;
            }
        }
        return 0;
    }
}
