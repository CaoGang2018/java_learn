package others.leecode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author admin_cg
 * @date 2020/8/30 16:11
 */
public class Solution_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> word = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && word.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
