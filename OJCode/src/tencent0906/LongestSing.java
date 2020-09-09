package tencent0906;

import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/9/7 18:18
 */
public class LongestSing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        nums[index] = 0;
        int sum = sc.nextInt();
        int[] dp = new int[sum];
        for (int i = 0; i < n; i++) {
            for (int j = sum-1; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        System.out.println(dp[sum - 1] + max);
    }
}
