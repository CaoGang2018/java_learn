package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/19 15:58
 */
public class Solution_12 {
    public static void main(String[] args) {
        Solution_12 ss = new Solution_12();
        System.out.println(ss.intToRoman(19984));
    }
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        if(num >= 1000){
            k = num / 1000;
            num = num % 1000;
            sb.append("M".repeat(k));
        }
        if(num >= 500){
            if(num >= 900){
                sb.append("CM");
                num -= 900;
            }
            else{
                sb.append("D");
                num -= 500;
            }
        }
        if(num >= 100){
            if(num >= 400){
                sb.append("CD");
                num -= 400;
            }
            else{
                k = num / 100;
                sb.append("C".repeat(k));
                num = num % 100;
            }
        }
        if(num >= 50){
            if(num >= 90){
                sb.append("XC");
                num -= 90;
            }
            else{
                sb.append("L");
                num -= 50;
            }
        }
        if(num >= 10){
            if(num >= 40){
                sb.append("XL");
                num -= 40;
            }
            else{
                k = num / 10;
                sb.append("X".repeat(k));
                num = num % 10;
            }
        }
        if(num >= 5){
            if(num >= 9){
                sb.append("IX");
                num -= 9;
            }
            else{
                sb.append("V");
                num -= 5;
            }
        }
        if(num >=4){
            sb.append("IV");
            num -= 4;
        }
        if(num > 0)
            sb.append("I".repeat(num));
        return sb.toString();

    }

}
