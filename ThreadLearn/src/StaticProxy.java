/**
 * @author admin_cg
 * @date 2020/8/9 15:03
 *
 * 静态代理模式
 * 真实对象和静态代理对象都要实现同一个接口
 * 代理对象需要代理真实对象
 *
 * 好处
 * 代理对象可以做很多真实对象做不到的事
 * 真实对象专注做自己的事
 */
public class StaticProxy {
    public static void main(String[] args) {

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }

}

interface Marry{
    void HappyMarry();
}

class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("Very Happy!");
    }
}

class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("收尾款！");
    }

    private void before() {
        System.out.println("布置现场！");
    }
}
