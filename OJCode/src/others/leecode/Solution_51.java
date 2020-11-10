package others.leecode;

import java.util.*;

/**
 * @author admin_cg
 * @data 2020/10/20 10:05
 */
public class Solution_51 {
    public static void main(String[] args) {
        Solution_51 solution_51 = new Solution_51();
        System.out.println(solution_51.solveNQueens(8).toString());
    }
    List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        int[] queue = new int[n];
        Arrays.fill(queue, -1);
        ans = new ArrayList<>();
        backward(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), queue);
        return ans;
    }

    private void backward(int n, int row, Set<Integer> col, Set<Integer> p1, Set<Integer> p2, int[] queue) {
        if (n == row){
            ans.add(generate(n, queue));
        } else {
            for (int i = 0; i < n; i++) {
                if (col.contains(i))
                    continue;
                int p = row - i;
                if (p1.contains(p))
                    continue;
                int q = row + i;
                if (p2.contains(q))
                    continue;
                col.add(i);
                p1.add(p);
                p2.add(q);
                queue[row] = i;
                backward(n, row + 1, col, p1, p2, queue);
                col.remove(i);
                p1.remove(p);
                p2.remove(q);
                queue[row] = -1;
            }
        }
    }

    private List<String> generate(int n, int[] temp) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] t = new char[n];
            Arrays.fill(t, '.');
            t[temp[i]] = 'Q';
            list.add(new String(t));
        }
        return list;
    }
}
