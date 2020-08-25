package others.leecode;

import java.util.Arrays;

/**
 * @author admin_cg
 * @date 2020/8/22 14:39
 * 并查集
 */
public class Solution_200 {
    public static void main(String[] args) {
        //char[][] grid = {{'1','1', '1'}, {'1', '0', '1'}, {'1', '1', '1'}};
        //char[][] grid = {{'1','0','1','1','1'}, {'1','0','1','0','1'}, {'1','1','1','0','1'}};
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        //char[][] grid = {{'1','1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        Solution_200 ss = new Solution_200();
        System.out.println(ss.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        UnionFind land = new UnionFind(row*col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    //if(i > 0 && grid[i-1][j] == '1') // up
                    //land.unionByHeight(changeIndex(i, j, col), changeIndex(i-1, j, col));
                    if(i < row -1 && grid[i+1][j] == '1') //down
                        land.unionByHeight(changeIndex(i, j, col), changeIndex(i+1, j, col));
                    //if(j > 0 && grid[i][j-1] == '1') // left
                    //land.unionByHeight(changeIndex(i, j, col), changeIndex(i, j-1, col));
                    if(j < col-1 && grid[i][j+1] == '1') // right
                        land.unionByHeight(changeIndex(i, j, col), changeIndex(i, j+1, col));
                }
                else land.count--;
                //land.print();
                //System.out.println(land.count);
            }
        }
        //land.print();
        return land.count;
    }

    public int changeIndex(int i, int j, int col){
        return i*col + j;
    }
}

class UnionFind{
    private int[] id;
    public int count;
    public UnionFind(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        id = new int[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    //二维变一维
                    id[i * n + j] = i * n + j;
                    count++;
                }
            }
        }
    }

    public UnionFind(int num) {
        this.id = new int[num + 1];
        this.count = num;
        for (int i = 0; i <= num; i++) {
            id[i] = i; // init
        }
    }
    public void print(){
        System.out.println(Arrays.toString(id));
    }
    public void unionByHeight(int root1, int root2){
        if(find(root1) == find(root2)) return;
        id[find(root1)] =find(root2);
        count--;
    }
    public int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
}