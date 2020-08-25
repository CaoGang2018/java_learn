package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/19 16:44
 */
public class Solution_16 {
    public static void main(String[] args) {
        Solution_16 ss = new Solution_16();
        int[] nums = {0, 2, 1, -3};
        System.out.println(ss.threeSumClosest(nums, 1));
    }
    public int threeSumClosest(int[] nums, int target) {
        int gap = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first -1])
                continue;
            int third = n - 1, second = first + 1;
            while(second < third){
                int ans = nums[first] + nums[second] +nums[third];
                if(ans == target)
                    return target;
                if(Math.abs(target-ans) < Math.abs(gap - target))
                    gap = ans;
                if(ans > target){
                    int k = third - 1;
                    while (second < k && nums[k] == nums[third])
                        k--;
                    third = k;
                }
                else{
                    int k = second + 1;
                    while (k < third && nums[k] == nums[second])
                        k++;
                    second = k;
                }
            }

        }
        return gap;

    }
}
