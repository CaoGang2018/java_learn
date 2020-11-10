package DesignPattern.DecoratorPattern;

/**
 * @author admin_cg
 * @data 2020/11/10 13:05
 */
public abstract class AbstractTeleScope4X implements Aim4x {
    private final Gun gun;

    public AbstractTeleScope4X(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void fire() {
        gun.fire();
    }
}
