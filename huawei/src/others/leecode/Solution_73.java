package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/26 17:18
 */
public class Solution_73 {
    public void setZeroes(int[][] matrix) {
        boolean isCol = false;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][0] == 0){
                    isCol = true;
                    break;
                }
            }
            for (int j = 1; j < col; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if(matrix[0][0] == 0){
            for (int i = 1; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if(isCol){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
