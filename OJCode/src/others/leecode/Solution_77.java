package others.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author admin_cg
 * @date 2020/9/8 16:02
 */
public class Solution_77 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] >='a' && chars[i] <= 'z'){
                chars[i] = (char)(chars[i] - 32);
            }
        }
        System.out.println(new String(chars));
    }
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        backtrack(n, new ArrayList<>(), 1, k);
        return ans;

    }
    private void  backtrack(int n, List<Integer> cur, int now, int k){
        if (cur.size() + (n - now + 1) < k) {
            return;
        }
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = now; i <= n; i++) {
            cur.add(i);
            backtrack(n, cur, i+1, k);
            cur.remove(cur.size()-1);
        }
    }
}
