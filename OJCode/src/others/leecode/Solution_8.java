package others.leecode;

/**
 * @author admin_cg
 * @date 2020/8/18 17:13
 */
public class Solution_8 {
    public static void main(String[] args) {
        String s = "  -0012a42";
        Solution_8 ss = new Solution_8();
        System.out.println(ss.myAtoi(s));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
    public int myAtoi(String str) {
        str = str.trim();
        System.out.println(str);
        if(str == null || str.length() == 0) return 0;
        boolean flag = true;
        if(str.charAt(0) == '-'){
            System.out.println(str.charAt(0));
            flag = false;
            int ans = atoi(str, 1, flag);
            return ans;
        }
        else if(str.charAt(0) == '+'){
            return atoi(str, 1, flag);
        }
        else return atoi(str, 0, flag);
    }

    public int atoi(String str, int st, boolean flag){
        int ans = 0;
        int start = st;
        int f = flag ? 1: -1;
        System.out.println(f);
        while(start < str.length()){
            if(str.charAt(start) < '0' || str.charAt(start) > '9'){
                return ans*f;
            }
            else{
                if(flag){
                    if((Integer.MAX_VALUE - (str.charAt(start) - '0')) / 10 < ans)
                        return Integer.MAX_VALUE;
                }
                else{
                    if((Integer.MIN_VALUE + (str.charAt(start) - '0')) / 10 * -1 < ans)
                        return Integer.MIN_VALUE;

                }
                ans = ans * 10 + (str.charAt(start) - '0');
                start++;

            }
        }
        return ans*f;
    }
}
