package others.leecode;

import others.nowcode.Solution;

import java.util.*;

/**
 * @author admin_cg
 * @date 2020/8/20 18:48
 */
public class Solution_347 {
    public static void main(String[] args) {
        Solution_347 ss = new Solution_347();
        int[] tm = new int[]{1,1,1,2,2,3};
        int k = 143;
        for(int s : ss.topKFrequent(tm, k))
            System.out.println(s);
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x, 1);
            }

        }
        /*

        int[] ans = new int[k];
        int m = 0;
        for(int key : map.keySet()){
            System.out.println(key);
            if(m < k){
                ans[m++] = key;
            }
            if(m == k){
                for(int i = ans.length/2-1; i >=0; i--){
                    adjustHeap(ans, i, map);
                }
                m++;
                System.out.println(Arrays.toString(ans));
            }
            else{
                if(map.get(key) > map.get(ans[0])){
                    ans[0] = key;
                    adjustHeap(ans, 0, map);
                    System.out.println(Arrays.toString(ans));
                }
            }
        }
        return ans;
         */
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for(int key : map.keySet()){
            if(queue.size() == k){
                if(map.get(key) > map.get(queue.peek())){
                    queue.poll();
                    queue.offer(key);
                }
            }
            else{
                queue.offer(key);
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i<k; i++){
            ans[i] = queue.poll();
        }
        return ans;
    }
    private void createtHeap(int[] nums, Map<Integer, Integer> map){
        for(int i = nums.length/2-1; i >=0; i--){
            adjustHeap(nums, i, map);
        }
    }

    private void adjustHeap(int[] nums, int i, Map<Integer, Integer> map){
        int len = nums.length;
        int tmp = nums[i];
        for(int k = i*2 + 1; k < len; k = 2*k + 1){
            if(k+1 < len && map.get(nums[k]) > map.get(nums[k+1])){
                k++;
            }
            if(map.get(nums[k]) < map.get(tmp)){
                nums[i] = nums[k];
                i = k;
            }
            else{
                break;
            }
        }
        nums[i] = tmp;
    }
}
