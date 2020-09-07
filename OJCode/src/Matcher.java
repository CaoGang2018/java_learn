/**
 * @author admin_cg
 * @date 2020/8/6 18:59
 */
public class Matcher {
    public static void main(String[] args) {
        String txt = "AAA333";
        String t = txt;
        String ps = "A*3";
        String[] p = ps.split("\\*");
//        System.out.println(p[0]);
        int count = 0;
        int index = 0;
        while(index < txt.length()){
            int t1 = txt.indexOf(p[0]);
            if(t1 == -1)
                break;
            index = t1 + p[0].length();
            txt = charReplace(txt, t1, index);
            int t2 = txt.indexOf(p[1], index);
            if(t2 == -1)
                break;
            txt = charReplace(txt, t2, t2 + p[1].length());
            if(t2 > t1)
                count++;
            System.out.println(t.substring(t1, t2+p[1].length()));
        }
        System.out.println(count);
    }
    public static String charReplace(String str, int start, int end){
        char[] x = str.toCharArray();
        for(int i = start; i < end; i++){
            x[i] = '+';
        }
        return new String(x);
    }
}
