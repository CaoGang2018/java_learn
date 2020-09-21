package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @data 2020/9/21 9:58
 */
public class Solution_209 {
    public int minSubArrayLenN(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while(end < n){
            sum += nums[end];
            while(sum >= s){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE? 0 : ans;
    }
    public int minSubArrayLenB(int s, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n+1];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        for (int i = 1; i < n; i++) {
            int target = s + sums[i-1];
            int bound = Arrays.binarySearch(sums, target);
            if(bound < 0)
                bound = -bound - 1;
            else{
                ans = Math.min(ans, bound-i+1);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
