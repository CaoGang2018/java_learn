package others.leecode;


/**
 * @author admin_cg
 * @data 2020/10/20 9:39
 */
public class Solution_143 {
    public void reorderList(ListNode head) {
        if (head == null) return;;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = revise(fast);
        fast = head;
        ListNode cur = slow;
        while (cur != null) {
            slow = cur.next;
            cur.next = fast.next;
            fast.next = cur;
            cur = slow;
            fast = fast.next.next;
        }
    }

    private ListNode revise(ListNode head) {
        ListNode root = new ListNode(-1);
        root.next = null;
        ListNode cur = head;
        while (cur != null) {
            head = cur.next;
            cur.next = root.next;
            root.next = cur;
            cur = head;
        }
        return root.next;
    }
}
