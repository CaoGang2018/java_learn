package others.sf;

/**
 * @author admin_cg
 * @data 2020/9/28 18:43
 */

class LinkNode{
    char val;
    LinkNode next;
    public LinkNode(char val) {
        this.val = val;
        this.next = null;
    }
}
public class ReviseK {
    public static void main(String[] args) {
        String s = "abcd", t = "aedbc";
        char[] c = {'a', 'b', 'c', 'd', 'e'};
        LinkNode head = new LinkNode(c[0]);
        LinkNode p = head;
        for (int i = 1; i < c.length; i++) {
            p.next = new LinkNode(c[i]);
            p = p.next;
        }
        ReviseK reviseK = new ReviseK();
        System.out.println(reviseK.addedChar(s, t));
        p = reviseK.reviseK(head, 2);
        while(p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
    public LinkNode reviseK(LinkNode head, int k) {
        if (k == 0) return helper(head);
        int i = 0;
        LinkNode p = head;
        while(i < k - 1){
            if(p == null) return head; // k > 链表长度 不翻转
            else p = p.next;
            i++;
        }
        p.next = helper(p.next);  // 翻转k以后链表
        return head;
    }
    public LinkNode helper(LinkNode head) {
        LinkNode root = new LinkNode('0');
        LinkNode p = head, q = null;
        while(p != null){
            q = p;
            p = p.next;
            q.next = root.next;
            root.next = q;
        }
        return root.next;

    }
    public char addedChar(String s, String t){
        int ans = 0;
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        ans ^= s.length() > t.length() ? s.charAt(n) : t.charAt(n);
        return (char)ans;
    }
}
