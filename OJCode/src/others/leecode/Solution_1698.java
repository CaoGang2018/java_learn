package others.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/26 21:32
 */
public class Solution_1698 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(nums, 0, ans, new ArrayList<>());
        return ans;

    }
    public void backtrack(int[] nums, int begin, List<List<Integer>>ans, List<Integer> cur){
        ans.add(new ArrayList<>(cur));
        for(int i = begin; i < nums.length; i++){
            cur.add(nums[i]);
            backtrack(nums, i+1, ans, cur);
            cur.remove(cur.size()-1);
        }
    }
}
