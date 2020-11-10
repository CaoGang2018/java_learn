package others.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author admin_cg
 * @data 2020/10/26 9:44
 */
public class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> temp = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) return output;
        temp.push(root);

        while (!temp.isEmpty()){
            TreeNode t = temp.pop();
            output.add(t.val);
            if (t.right != null){
                temp.push(t.right);
            }
            if (t.left != null){
                temp.push(t.left);
            }
        }
        return output;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) return output;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == cur) {
                output.add(root.val);
                cur = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return output;
    }
}
