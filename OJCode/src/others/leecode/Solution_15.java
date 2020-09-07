package others.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/19 15:16
 */
public class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums){
        if(nums.length < 3) return null;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first-1])
                continue;

            int third = n-1;
            int target = -nums[first];
            for (int second = first+1; second < n; second++) {
                if(second > first+1 && nums[second] == nums[second-1])
                    continue;
                while (second < third && nums[second] + nums[third] > target)
                    third--;

                if(second == third)
                    break;
                if(nums[first] + nums[second] + nums[third] == 0){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[first]);
                    tmp.add(nums[second]);
                    tmp.add(nums[third]);
                    ans.add(tmp);
                }
            }
        }
        return ans;
    }
}
