package others.leecode;

/**
 * @author admin_cg
 * @date 2020/9/3 19:10
 */
public class Solution_124 {
    private int maxNum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxNum;
    }
    private int maxPath(TreeNode root){
        if(root == null)
            return 0;
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        int curMax = root.val + left + right;
        maxNum = Math.max(curMax, maxNum);
        return root.val + Math.max(left, right);
    }
}
