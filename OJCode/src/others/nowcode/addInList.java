package others.nowcode;

import java.util.List;

/**
 * @author admin_cg
 * @date 2020/9/5 18:49
 */
public class addInList {
    public ListNode addInList1 (ListNode head1, ListNode head2) {
        // write code here
        ListNode p = reverse(head1);
        ListNode q = reverse(head2);
        return reverse(sumList(p, q, 0));

    }
    public ListNode sumList(ListNode s1, ListNode s2, int buy) {
        int currentLevelSum = s1.val + s2.val + buy;
        ListNode currentNode = new ListNode(currentLevelSum % 10);
        if (s1.next == null && s2.next == null) {
            if (currentLevelSum / 10 != 0) {
                currentLevelSum = currentLevelSum/10;
                currentNode.next = new ListNode(currentLevelSum);
            }
            return currentNode;
        }
        s1 = s1.next != null ? s1.next : new ListNode(0);
        s2 = s2.next != null ? s2.next : new ListNode(0);

        currentNode.next = sumList(s1, s2, currentLevelSum / 10);
        return currentNode;
    }
    public ListNode reverse (ListNode head){
        ListNode root = new ListNode(-1);
        ListNode p = head;
        while (p != null){
            p = p.next;
            head.next = root.next;
            root.next = head;
            head = p;
        }
        return root.next;
    }
}

