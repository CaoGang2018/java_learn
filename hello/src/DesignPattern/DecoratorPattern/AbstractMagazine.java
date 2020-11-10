package DesignPattern.DecoratorPattern;

/**
 * @author admin_cg
 * @data 2020/11/10 12:49
 */
public abstract class AbstractMagazine implements Gun {
    private final Gun gun;

    public AbstractMagazine(Gun gun) {
        this.gun = gun;
    }

    @Override
    public void fire() {
        gun.fire();
    }
}
