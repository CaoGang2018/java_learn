package DesignPattern.DecoratorPattern;

/**
 * @author admin_cg
 * @data 2020/11/10 13:07
 */
public class TeleScope4X extends AbstractTeleScope4X {
    public TeleScope4X(Gun gun) {
        super(gun);
    }

    @Override
    public void aim4x() {
        System.out.println("已进入4倍瞄准模式");
    }
}
