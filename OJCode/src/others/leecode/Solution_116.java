package others.leecode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author admin_cg
 * @date 2020/8/30 13:31
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class Solution_116 {
    public Node connect(Node root) {
        if(root == null || root.left == null)    return root;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
}
