package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/19 18:25
 */
public class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode p = head;
        if(l1.val <= l2.val)
            l1 = l1.next;
        else l2 = l2.next;
        while(true){
            if(l1 == null){
                p.next = l2;
                break;
            }
            if(l2 == null){
                p.next = l1;
                break;
            }
            p.next = l1.val <= l2.val ? l1 : l2;
            p = p.next;
            if(l1.val <= l2.val)
                l1 = l1.next;
            else l2 = l2.next;
        }
        return head;
    }
}
