package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/26 14:52
 */
public class Solution_698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, maxNum = 0;
        for(int num : nums){
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if(sum % k !=0 || maxNum > sum / k) return false;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, used, k, sum/k, 0, 0);
    }

    private boolean backtrack(int[] nums, boolean[] used, int k, int target, int cur, int start) {
        if(k == 0) return true;
        if(cur == target)
            return backtrack(nums, used, k-1, target, 0, 0);
        for (int i = start; i < nums.length; i++) {
            if(!used[i] && cur + nums[i] <= target){
                used[i] = true;
                if(backtrack(nums, used, k, target, cur+nums[i], i+1))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }


}
