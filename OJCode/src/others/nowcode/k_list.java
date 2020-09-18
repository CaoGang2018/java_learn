package others.nowcode;

import java.util.ArrayList;

/**
 * @author admin_cg
 * @date 2020/9/4 20:41
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class k_list {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) return null;
        if(lists.size() == 1)
            return lists.get(0);
        ListNode head = new ListNode(0);
        ListNode p = lists.get(0);
        ListNode q = lists.get(1);
        head.next = towMgrge(p, q);
        for(int i = 2; i < lists.size(); i++){
            q = lists.get(i);
            if(q == null) continue;
            p = head.next;
            head.next = null;
            head.next = towMgrge(p, q);
        }
        return head.next;
    }
    private ListNode towMgrge(ListNode list1, ListNode list2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(list2 != null && list1 != null){
            if(list2.val >= list1.val){
                p.next = list1;
                list1 = list1.next;
            }
            else{
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        p.next = list2 == null ? list1 : list2;
        return head.next;
    }
}
