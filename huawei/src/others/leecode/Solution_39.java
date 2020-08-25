package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/21 16:04
 */
public class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        /*int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < candidates.length; i++){
            for(int j = 1; j <= target; j++){
                if(j - candidates[i] >= 0)
                    dp[j] = dp[j] + dp[j - candidates[i]];
            }
        }*/
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, len, target, 0, new ArrayDeque<>(), ans);
        return ans;
    }

    private void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> ans){
        if(residue == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if(residue - candidates[i] < 0)
                break;
            path.addLast(candidates[i]);
            dfs(candidates, len, residue-candidates[i], i, path, ans);
            path.removeLast();
        }
    }
}
