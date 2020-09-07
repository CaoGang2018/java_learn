package others.nowcode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/8 15:51
 */
public class laji {
    public static void main(String[] args) {
        int[] a = {30, 60, 5, 15, 30};
        Arrays.sort(a); //升序
        int count = 0;
        int i = 0;
        while(!canPartition(a)){
            if(i == a.length) break;
            System.out.println(canPartition(a));
            count += a[i];
            a[i] = 0;
            i++;
        }
        System.out.println(count);

    }


    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >= 0; j--){
                if(j - nums[i] >= 0){
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
        }
        return dp[sum];

    }
}
