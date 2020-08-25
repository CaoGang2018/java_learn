package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/17 21:25
 */
public class Solution_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] t = str.toCharArray();
            Arrays.sort(t);
            List<String> ls;
            if (map.containsKey(Arrays.toString(t))) {
                ls = map.get(Arrays.toString(t));
            } else {
                ls = new LinkedList<>();
            }
            ls.add(str);
            map.put(Arrays.toString(t), ls);
        }
        List<List<String>> ans = new LinkedList<>();
        for(String s : map.keySet()){
            ans.add(map.get(s));
        }
        return ans;
    }
}
