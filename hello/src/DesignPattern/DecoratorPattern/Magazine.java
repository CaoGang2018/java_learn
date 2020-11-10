package DesignPattern.DecoratorPattern;

/**
 * @author admin_cg
 * @data 2020/11/10 12:53
 */
public class Magazine extends AbstractMagazine {
    public Magazine(Gun gun) {
        super(gun);
    }

    @Override
    public void fire() {
        System.out.println("shot * 40!");
    }
}
