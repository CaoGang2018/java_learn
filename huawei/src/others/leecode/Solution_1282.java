package others.leecode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/8/13 12:43
 */
public class Solution_1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < groupSizes.length; i++){
            if(!map.containsKey(groupSizes[i])){
                map.put(groupSizes[i], new ArrayList<>());
            }
            List<Integer> t = map.get(groupSizes[i]);
            t.add(i);
            if(t.size() == groupSizes[i]){
                ans.add(new ArrayList<>(t));
                t.clear();
            }
        }
        return ans;

    }
}
