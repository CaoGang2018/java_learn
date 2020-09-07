package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/24 12:58
 */
public class Solution_1254 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0}, {1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        Solution_1254 ss = new Solution_1254();
        System.out.println(ss.closedIsland(grid));
    }
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        UnionFindClosedIsland uf = new UnionFindClosedIsland(row*col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    uf.waterConnected();
                }
                else{
                    if(i == 0 || i == row - 1 || j == 0 || j == col-1)
                        uf.union(row*col, changeIndex(i, j, col));
                    if(i+1 < row && grid[i+1][j] == 0)
                        uf.union(changeIndex(i+1, j, col), changeIndex(i, j, col));
                    if(j+1 < col && grid[i][j+1] == 0)
                        uf.union(changeIndex(i, j+1, col), changeIndex(i, j, col));
                }
            }
        }
        uf.print();
        return uf.getCount();
    }

    private int changeIndex(int i, int j, int col){
        return i * col + j;
    }
}

class UnionFindClosedIsland{
    private final int[] parent;
    private int count;

    public UnionFindClosedIsland(int num) {
        this.parent = new int[num+1]; // num用于边界island
        this.count = num;
        for (int i = 0; i < num + 1; i++) {
            this.parent[i] = i;  // init
        }
    }

    public void print(){
        System.out.println(Arrays.toString(parent));
    }

    public int getCount() {
        return count;
    }

    public void waterConnected(){
        count--;
    }
    public int find(int x){
        while(parent[x] != x){
            x = parent[x];
        }
        return x;
    }

    public void union(int p, int q){
        int parentP = find(p);
        int parentQ = find(q);
        if(parentP == parentQ) return;
        if(parentP > parentQ)
            parent[parentP] = parent[parentQ];
        else
            parent[parentQ] = parent[parentP];
        count--;
    }
}
