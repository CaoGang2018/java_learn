package others.leecode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/8/18 17:03
 */
public class Solution_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        boolean goingDown = false;
        int row = 0;
        for (int i = 0; i < s.length(); i++) {
            rows.get(row).append(s.charAt(i));
            if(row == 0 || row == numRows - 1) goingDown = !goingDown;
            row += goingDown? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder sy : rows){
            sb.append(sy);
        }
        return sb.toString();
    }
}
