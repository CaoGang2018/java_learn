package DesignPattern.DecoratorPattern;

/**
 * @author admin_cg
 * @data 2020/11/10 12:54
 */
public class M4Demo {
    public static void main(String[] args) {
        System.out.println("捡起一把M4！");
        Gun gun = new M4();
        System.out.println("fire");
        gun.fire();
        System.out.println("===============");
        System.out.println("捡起扩容弹夹！");
        gun = new Magazine(gun);
        System.out.println("fire");
        gun.fire();
        System.out.println("===============");
        System.out.println("捡起4倍镜");
        Aim4x aim4x = new TeleScope4X(gun);
        aim4x.aim4x();
        aim4x.fire();
    }
}
