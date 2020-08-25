package others.leecode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/25 13:30
 */
public class Solution_491 {
    public static void main(String[] args) {
        int[] t = {4, 6, 7, 7};
        Solution_491 ss = new Solution_491();
        ss.findSubsequences(t);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if(nums == null) return ans;
        backtrack(nums, new LinkedList<Integer>(), 0, Integer.MIN_VALUE, ans);
        for(List<Integer> ls : ans)
            System.out.println(ls.toString());
        return ans;
    }

    private void backtrack(int[] nums, List<Integer> list, int begin, int len, List<List<Integer>> ans) {
        if(begin >= nums.length){
            if(list.size() >= 2)
                ans.add(new LinkedList<>(list));
            return;
        }
        if(nums[begin] >= len){
            list.add(nums[begin]);
            backtrack(nums, list, begin+1, nums[begin], ans);
            list.remove(list.size() - 1);
        }
        if(nums[begin] != len){
            backtrack(nums, list, begin+1, len, ans);
        }
    }

}
