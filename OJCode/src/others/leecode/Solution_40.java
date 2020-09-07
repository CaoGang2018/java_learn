package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/21 18:24
 */
public class Solution_40 {
    public static void main(String[] args) {
        Solution_40 ss = new Solution_40();
        int[] t = {10,1,2,7,6,1,5};
        for(List<Integer> s : ss.combinationSum2(t, 8))
            System.out.println(s.toString());
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, len, target, 0, new ArrayDeque<>(), ans);
        return ans;
    }

    private void dfs(int[] candidates, int len, int residue, int begin, Deque<Integer> path, List<List<Integer>> ans){
        if(residue == 0){
            //if(ans.contains(new ArrayList<>(path))) return;
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < len; i++){
            if(residue - candidates[i] < 0)
                break;
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            path.addLast(candidates[i]);
            dfs(candidates, len, residue-candidates[i], i+1, path, ans);
            path.removeLast();
        }
    }
}
