package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/20 20:56
 */
public class Solution_692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String str : words){
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }
            else{
                map.put(str, 1);
            }
        }
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for(String key : map.keySet()){
            if(queue.size() < k){
                queue.offer(key);
            }
            else{
                if(map.get(key) > map.get(queue.peek())){
                    queue.poll();
                    queue.offer(key);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(String key : queue){
            ans.add(key);
        }
        return ans;

    }
}
