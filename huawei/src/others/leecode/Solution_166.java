package others.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin_cg
 * @date 2020/8/30 16:40
 */
public class Solution_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator < 0)^(denominator<0))
            sb.append('-');
        long num = Math.abs(Long.valueOf(numerator));
        long div = Math.abs(Long.valueOf(denominator));
        sb.append(num / div);
        long modNum = num % div;
        if(modNum == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (modNum != 0){
            if(map.containsKey(modNum)){
                sb.insert(map.get(modNum), "(");
                sb.append(")");
                break;
            }
            map.put(modNum, sb.length());
            modNum *= 10;
            sb.append(modNum / div);
            modNum %= div;
        }
        return sb.toString();
    }
}
