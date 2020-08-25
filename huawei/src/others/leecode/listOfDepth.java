package others.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author admin_cg
 * @date 2020/8/13 11:59
 *  给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 */



// Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

 // Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class listOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if(tree == null) return new ListNode[0];
        List<ListNode> ans = new ArrayList<>();
        Queue<TreeNode> tp = new LinkedList<>();
        tp.offer(tree);
        int k = 1, t = 0;
        ListNode tmp = new ListNode(0), p = tmp;
        while(!tp.isEmpty()){
            TreeNode t1 = tp.poll();
            k--;
            if(t1.left != null){
                tp.offer(t1.left);
                t++;
            }
            if(t1.right != null){
                tp.offer(t1.right);
                t++;
            }
            p.next = new ListNode(t1.val);
            p = p.next;
            if(k == 0){
                ans.add(tmp.next);
                tmp.next = null;
                p = tmp;
                k = t;
                t = 0;
            }
        }
        return (ListNode[])ans.toArray(new ListNode[ans.size()]);
    }

}
