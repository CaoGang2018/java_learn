package others.leecode;

import java.util.LinkedHashMap;

/**
 * @author admin_cg
 * @date 2020/8/28 14:32
 */

public class LRUCache_146 {
    int capacity;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    public LRUCache_146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            makeRecently(key);
            return;
        }
        if(cache.size() >= this.capacity){
            int temp = cache.keySet().iterator().next();
            cache.remove(temp);
        }
        cache.put(key, value);

    }

    private void makeRecently(int key){
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}
