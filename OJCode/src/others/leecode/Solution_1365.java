package others.leecode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/8/31 15:35
 */
public class Solution_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums.length == 0) return new int[0];
        int len = nums.length;
        Map<Integer, HashSet<Integer>> temp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(!temp.containsKey(nums[i])) temp.put(nums[i], new HashSet<Integer>());
            temp.get(nums[i]).add(i);
        }
        int[] ans = new int[len];
        Arrays.sort(nums);
        for (int i = len-1; i >= 0; i--) {
            if(i-1>=0 && nums[i] == nums[i-1]) continue;
            for(int j : temp.get(nums[i])) ans[j] = i;
        }
        return ans;
    }
}
