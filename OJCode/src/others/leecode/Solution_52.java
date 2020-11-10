package others.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author admin_cg
 * @data 2020/10/19 21:00
 */
public class Solution_52 {
    public static void main(String[] args) {
        Solution_52 solution_52 = new Solution_52();
        System.out.println(solution_52.totalNQueens(8));
    }
    public int totalNQueens(int n) {
        return backward(n, 0, new HashSet<Integer>(), new HashSet<Integer>(), new HashSet<Integer>());
    }

    private int backward(int n, int row, Set<Integer> col, Set<Integer> p1, Set<Integer> p2) {
        if (n == row) return 1;
        else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (col.contains(i)){
                    continue;
                }
                int p = i + row;
                if (p1.contains(p)){
                    continue;
                }
                int q = row - i;
                if (p2.contains(q)){
                    continue;
                }
                col.add(i);
                p1.add(p);
                p2.add(q);
                count += backward(n, row + 1, col, p1, p2);
                col.remove(i);
                p1.remove(p);
                p2.remove(q);
            }
            return count;
        }
    }
}
