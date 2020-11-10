package others.leecode;

/**
 * @author admin_cg
 * @data 2020/10/23 9:44
 */
public class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = null;
        fast = slow.next;
        slow.next = null;
        while (fast != null){
            cur = fast;
            fast = fast.next;
            cur.next = slow.next;
            slow.next = cur;
        }
        fast = slow.next;
        slow = head;
        while (fast != null){
            if (slow.val != fast.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
