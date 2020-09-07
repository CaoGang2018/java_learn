package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/21 20:39
 */
public class Solution_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        List<int[]> an = new ArrayList<>();
        //for(int num:nums)
         //   cur.add(num);
        //backtrack(nums, 0, ans, cur);
        backtrack2(nums, ans, cur);
        return ans;
    }

    private void backtrack(int[] nums, int begin, List<List<Integer>> ans, ArrayList<Integer> cur){
        if(begin == nums.length){
            ans.add(new ArrayList<>(cur));
        }
        for(int i = begin; i < nums.length; i++){
            Collections.swap(cur, begin, i);
            backtrack(nums, begin+1, ans, cur);
            Collections.swap(cur, begin, i);
        }
    }

    private void backtrack2(int[] nums,List<List<Integer>> ans, LinkedList<Integer> cur){
        if(cur.size() == nums.length){
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int num : nums) {
            if (cur.contains(num))
                continue;
            cur.add(num);
            backtrack2(nums, ans, cur);
            cur.removeLast();
        }
    }

}
