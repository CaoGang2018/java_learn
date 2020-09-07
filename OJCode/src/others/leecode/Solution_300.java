package others.leecode;

/**
 * @author admin_cg
 * @date 2020/9/3 9:44
 */
public class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int maxTemp = 0;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    maxTemp = Math.max(maxTemp, dp[j]);
                }
                dp[i] = 1 + maxTemp;
                maxTemp = 0;
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[1] = nums[0];
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] > dp[maxLen])
                dp[++maxLen] = nums[i];
            else{
                int l = 1, r = maxLen, cur = 0;
                while (l <= r){
                    int mid = l + (r - l) / 2;
                    if(dp[mid] < nums[i]){
                        cur = mid;
                        l = mid + 1;
                    }
                    else r = mid - 1;
                }
                dp[cur + 1] = nums[i];
            }
        }
        return maxLen;
    }

}
