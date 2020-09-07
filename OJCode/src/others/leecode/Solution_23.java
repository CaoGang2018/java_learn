package others.leecode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author admin_cg
 * @date 2020/8/17 20:34
 */
public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        Queue<ListNode> tree = new PriorityQueue<ListNode>((o1, o2) -> (o1.val - o2.val));
        for (int i = 0; i < lists.length; i++){
            if(lists[i] == null) continue;
            ListNode tp = lists[i];
            while(tp != null){
                tree.add(tp);
                tp = tp.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(tree.size() != 0){
            p.next = tree.poll();
            p = p.next;
        }
        return head.next;

    }
}
