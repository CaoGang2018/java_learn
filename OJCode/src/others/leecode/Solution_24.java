package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/19 19:03
 */
public class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head;
        ListNode q = p.next;

        p.next = swapPairs(q.next);
        q.next = p;

        return q;
    }
}
