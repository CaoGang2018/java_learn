package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/21 15:43
 */
public class Solution_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = helper(nums, target, true);
        if(left == nums.length || nums[left] != target )
            return ans;
        ans[0] = left;
        ans[1] = helper(nums, target, false) -1 ;
        return ans;
    }

    public int helper(int[] nums, int target, boolean left){
        int l = 0, h = nums.length;
        while(l < h){
            int mid = (h=l)/2;
            if(nums[mid] > target || (left && nums[mid] == target)){
                h = mid;
            }
            else {
                l = mid + 1;
            }
        }
        return l;
    }
}
