package others.leecode;

/**
 * @author admin_cg
 * @data 2020/10/14 15:40
 */
public class Solution_86 {
    public ListNode partition(ListNode head, int x) {
        ListNode minHead = new ListNode(-1);
        ListNode minCur = minHead;
        ListNode maxHead = new ListNode(-1);
        ListNode maxCur = maxHead;
        while (head != null){
            if (head.val < x){
                minCur.next = head;
                head = head.next;
                minCur.next.next = null;
                minCur = minCur.next;
            } else {
                maxCur.next = head;
                head = head.next;
                maxCur.next.next = null;
                maxCur = maxCur.next;
            }
        }
        minCur.next = maxHead.next;
        return minHead.next;
    }
}
