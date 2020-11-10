package others.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @data 2020/10/22 20:44
 */
public class Solution_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            List<Integer> temp = ans.get(i-1);

            cur.add(1);
            for (int j = 1; j < i; j++){
                cur.add(temp.get(j-1) + temp.get(j));
            }
            cur.add(1);
            ans.add(cur);
        }
        return ans;
    }
}
