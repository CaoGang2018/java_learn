package others.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin_cg
 * @data 2020/10/22 9:24
 */
public class Solution_763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] last = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(last[S.charAt(i) - 'a'], end);
            if (i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
