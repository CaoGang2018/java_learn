package others.nowcode;

/**
 * @author admin_cg
 * @date 2020/8/8 16:23
 */
public class earlyClose {
    public static void main(String[] args) {
        int[] a = {20, 25};
        int[] b = {40};
        int count = 0;
        if(a.length == 0)
            System.out.println("08:00:00 am");
        if(a.length == 1 && b.length == 0)
            System.out.printf("08:00:%02d am", a[0]);
        for(int i = 0, j=0; i < b.length; i++){
            if(a[j] + a[j+1] > b[i]){
                count += a[i];
                j++;
            }
            else{
                count += b[i];
                j += 2;
            }
        }
        int h = 0, m=0, s = 0;
        s = count % 60;
        m = count / 60 % 60;
        h = count / 60 / 60 + 8;
        if(h > 12)
            System.out.printf("%02d:%02d:%02d pm",h, m, s);
        else
            System.out.printf("%02d:%02d:%02d am",h, m, s);

    }


}
