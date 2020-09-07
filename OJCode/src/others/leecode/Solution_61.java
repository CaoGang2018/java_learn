package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/29 14:27
 */
public class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;
        int c = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            c++;
        }
        k %= c;
        if(k == 0) return head;
        ListNode p = head, q = head;
        while(k > 0){
            q = q.next;
            --k;
        }
        while(q != tail){
            p = p.next;
            q = q.next;
        }
        q = p.next;
        p.next = null;
        tail.next = head;
        return q;
    }
}
