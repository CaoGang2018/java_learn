package others.nowcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/9/4 19:29
 */
public class LRU {
    private LinkedHashMap<Integer, Integer> map;
    public int[] LRUa (int[][] operators, int k) {
        // write code here
        map = new LinkedHashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int[] operator : operators) {
            if(operator[0] == 1){
                set(operator[1], operator[2], k);
            }
            else if(operator[0] == 2){
                ans.add(get(operator[1]));
            }
        }
        int[] ansArr = new int[ans.size()];
        int i = 0;
        for (int num : ans)
            ansArr[i++] = num;
        return ansArr;
    }
    private void set(int key, int v, int k){
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, v);
        }
        else if(map.size() == k){
            moveLast();
            map.put(key, v);
        }
        else{
            map.put(key, v);
        }
    }
    private int get(int k){
        if(map.containsKey(k)) {
            int out = map.get(k);
            map.remove(k);
            map.put(k, out);
            return out;
        }
        return -1;
    }
    private void moveLast(){
        int k = map.keySet().iterator().next();
        map.remove(k);
    }
}
