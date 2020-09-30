import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author admin_cg
 * @data 2020/9/27 20:28
 */
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class LinkMap {
    int val;
    ListNode pre;

    public LinkMap(int val, ListNode pre) {
        this.val = val;
        this.pre = pre;
    }
}
class map{
    int val;
    int index;
    int ind; // 原数组坐标

    public map(int val, int index, int ind) {
        this.val = val;
        this.index = index;
        this.ind = ind;
    }
}
public class KArrays {
    public static void main(String[] args) {
        int[][] nums = {{1, 4, 5}, {1, 3, 4}, {2, 6, 0}};
        KArrays kArrays = new KArrays();
        System.out.println(Arrays.toString(kArrays.mergeKArrays(nums)));
    }
    public int[] mergeKArrays(int[][] nums){
        int m = nums.length, n = nums[0].length;
        PriorityQueue<map> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < nums.length; i++){
            if(nums[i][0] != 0){
                queue.add(new map(nums[i][0], i, 1));
            }
        }
        int[] ans = new int[n*m];
        int index = 0;
        while (!queue.isEmpty()){
            map t = queue.poll();
            ans[index++] = t.val;
            if(t.ind < m){
                int tmp =  nums[t.index][t.ind];
                if(tmp != 0){
                    queue.add(new map(tmp, t.index, t.ind + 1));
                }
            }
        }
        return ans;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<LinkMap> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if(list != null){
                queue.add(new LinkMap(list.val, list));
            }
        }
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (!queue.isEmpty()){
            LinkMap t = queue.poll();
            cur.next = t.pre;
            cur = cur.next;
            if(t.pre.next != null){
                queue.add(new LinkMap(t.pre.next.val, t.pre.next));
            }
        }
        return head.next;
    }
}
