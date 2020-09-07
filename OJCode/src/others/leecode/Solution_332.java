package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/27 19:14
 */
public class Solution_332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> ans = new LinkedList<>();
        for(List<String> t : tickets){
            String str = t.get(0);
            if(!map.containsKey(str)){
                map.put(str, new PriorityQueue<String>());
            }
            map.get(str).offer(t.get(1));
        }
        dfs("JFK", ans, map);
        Collections.reverse(ans);
        return ans;
    }

    private void dfs(String cur, List<String> ans, Map<String, PriorityQueue<String>> map) {
        while(map.containsKey(cur) && map.get(cur).size() > 0){
            String temp = map.get(cur).poll();
            dfs(temp, ans, map);
        }
        ans.add(cur);
    }

}
