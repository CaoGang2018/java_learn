package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/30 13:09
 */
public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        return sortedArrayToBSTHelper(nums, 0, nums.length);

    }
    public TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
        if(start == end) return null;
        int mid = start +(end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, start, mid);
        root.right = sortedArrayToBSTHelper(nums, mid+1, end);
        return root;
    }
}
