package others.nowcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author admin_cg
 * @date 2020/8/11 14:44
 */
public class SurroundArea {

    public static void main(String[] args) {
        char[][] board = {{'X','O','X','O','X','O'}, {'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.printf("\n");

        }

        System.out.printf("==========================\n");
        SurroundArea surroundArea = new SurroundArea();
        surroundArea.solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.printf(board[i][j] + " ");
            }
            System.out.printf("\n");
        }
    }

    public void solve(char[][] board){
        if(board == null || board.length == 0)
            return;

        int rows = board.length;
        int cols = board[0].length;

        int oNode = rows * cols;
        UnionFind uf = new UnionFind(oNode + 1);

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if(board[i][j] == 'O'){
                    if(i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
                        uf.union(sigleIndex(i, j, cols), oNode);
                    }
                    else{
                        if(i > 0 && board[i - 1][j] == 'O')
                            uf.union(sigleIndex(i, j, cols), sigleIndex(i-1, j, cols));
                        if(i < rows - 1 && board[i + 1][j] == 'O')
                            uf.union(sigleIndex(i, j, cols), sigleIndex(i+1, j, cols));
                        if(j > 0 && board[i][j - 1] == 'O')
                            uf.union(sigleIndex(i, j, cols), sigleIndex(i, j - 1, cols));
                        if(j < cols - 1 && board[i][j + 1] == 'O')
                            uf.union(sigleIndex(i, j, cols), sigleIndex(i, j + 1, cols));
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!uf.isConnected(sigleIndex(i, j, cols), oNode))
                    board[i][j] = 'X';
            }
        }
    }

    public int sigleIndex(int i, int j, int cols){
        return i * cols + j;
    }


}

class UnionFind{
    int[] parents;

    public UnionFind(int totalNode) {
        parents = new int[totalNode];
        for(int i = 0; i < totalNode; i++){
            parents[i] = i;
        }
    }

    public void union(int node1, int node2){
        int root = find(node1);
        int root2 = find(node2);
        if(root2 != root){
            parents[root2] = root;
        }
    }

    private int find(int node1) {
        while(parents[node1] != node1){
            parents[node1] = parents[parents[node1]];
            node1 = parents[node1];
        }
        return node1;
    }
    boolean isConnected(int node1, int node2){
        return find(node1) == find(node2);
    }
}
