package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/13 13:39
 */
public class Solution1315 {
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        if(root.val % 2 == 0){
            int left = count(root.left) + sumEvenGrandparent(root.left);
            int right = count(root.right) + sumEvenGrandparent(root.right);
            return left + right;
        }
        else{
            int left = sumEvenGrandparent(root.left);
            int right = sumEvenGrandparent(root.right);
            return left + right;
        }
    }
    public int count(TreeNode root){
        int rum = 0;
        if(root == null) return 0;
        if(root.left != null) rum += root.left.val;
        if(root.right != null) rum += root.right.val;
        return rum;
    }
}
