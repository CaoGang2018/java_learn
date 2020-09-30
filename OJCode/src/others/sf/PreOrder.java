package others.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @data 2020/9/28 18:22
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * 输入: [1,2,3,null,null,4,5]
 *    1
 *  /  \
 * 2   3
 *     / \
 *    4   5
 *
 * 输出: [1,2,3,4,5]
 */
public class PreOrder {
    List<Integer> ans = new ArrayList<>(); // 全局变量用于存结果
    public void preOrder(TreeNode root){
        if (root == null) return;
        ans.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
}
