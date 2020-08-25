/**
 * @author admin_cg
 * @date 2020/8/4 20:26
 */
public class Demo03 {
    // 十六进制 0x  八进制 0  二进制 0b
    public static void main(String[] args) {
        int i = 10;
        int i2 = 010;
        int i3 = 0x10;
        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);

        // 浮点数 误差

        float f = 0.1f;
        double d = 1.0 / 10;
        System.out.println(f == d);
        System.out.println(Math.pow(2, 3));

    }
}
