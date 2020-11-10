package others.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin_cg
 * @data 2020/10/25 16:16
 */
public class Solution_117 {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; i++) {
                Node cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
                if (i != 1){
                    last.next = cur;
                }
                last = cur;
            }
        }
        return root;
    }
}
